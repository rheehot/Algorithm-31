package Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Kakao2021Four {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



        bw.flush();
        bw.close();
    }

    static List<PointNode> list[];
    static int dist[];
    static boolean check[];
    static int n, v;
    private static final int INF = 200_000_000;
    public static int solution(int n, int s, int a, int b, int[][] fares) {

        list = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        dist = new int[n + 1];
        check = new boolean[n + 1];

        for(int i = 0; i < fares.length; i++) {
            list[fares[i][0]].add(new PointNode(fares[i][1], fares[i][2]));
            list[fares[i][1]].add(new PointNode(fares[i][0], fares[i][2]));
        }

        int answer = dijkstra(s, a) + dijkstra(s, b);
        answer = Math.min(answer, dijkstra(s,b) + dijkstra(b, a));
        answer = Math.min(answer, dijkstra(s, a) + dijkstra(a, b));

        return answer;
    }

    public static int dijkstra(int start, int end) {
        Arrays.fill(dist, INF);
        Arrays.fill(check, false);

        PriorityQueue<PointNode> q = new PriorityQueue<>();
        q.add(new PointNode(start, 0));
        dist[start] = 0;

        while(!q.isEmpty()) {
            PointNode curPoint = q.poll();
            int curNode = curPoint.end;
            int curWeight = curPoint.weight;

            if(check[curNode] == true) {
                continue;
            }

            check[curNode] = true;

            for(int i = 0; i < list[curNode].size(); i++) {
                int nextNode = list[curNode].get(i).end;
                int nextWeight = list[curNode].get(i).weight;

                if(check[nextNode] == false && dist[nextNode] > curWeight + nextWeight) {
                    dist[nextNode] = curWeight + nextWeight;
                    q.add(new PointNode(nextNode, dist[nextNode]));
                }
            }
        }
        return dist[end];
    }
}

class PointNode implements Comparable<PointNode> {
    int end;
    int weight;

    public PointNode(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(PointNode o) {
        return weight - o.weight;
    }
}
