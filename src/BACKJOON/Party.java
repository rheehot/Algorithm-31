package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Party {

    static final int INF = 200_000_000;
    static List<PartyNode>[] list, revList;
    static int dist[], revDist[];
    static int n, m;

    static int target;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        revList = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
            revList[i] = new ArrayList<>();
        }

        dist = new int[n + 1];
        revDist = new int[n + 1];

        Arrays.fill(dist, INF);
        Arrays.fill(revDist, INF);

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            list[start].add(new PartyNode(end, time));
            revList[end].add(new PartyNode(start, time));
        }

        dijkstra(list, dist);
        dijkstra(revList, revDist);

        int max = 0;
        for(int i = 1; i <= n; i++) {
            if(max < dist[i] + revDist[i]) {
                max = dist[i] + revDist[i];
            }
        }

        bw.write(max + "");
        bw.flush();
        bw.close();
    }

    static void dijkstra(List<PartyNode>[] list, int[] distance) {
        boolean[] visit = new boolean[n + 1];
        PriorityQueue<PartyNode> pq = new PriorityQueue<>();

        distance[target] = 0;
        pq.add(new PartyNode(target, 0));

        while(!pq.isEmpty()) {
            int idx = pq.poll().end;

            if(visit[idx])
                continue;
            visit[idx] = true;

            for(PartyNode node : list[idx]) {
                if(distance[node.end] > distance[idx] + node.weight) {
                    distance[node.end] = distance[idx] + node.weight;
                    pq.add(new PartyNode(node.end, distance[node.end]));
                }
            }
        }
    }
}

class PartyNode implements Comparable<PartyNode>{
    int end;
    int weight;

    PartyNode(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(PartyNode o) {
        return weight - o.weight;
    }
}
