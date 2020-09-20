package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class GetCheaper {
    static int N, M;
    static int[] dist;
    static List<GetNode>[] list;
    static int INF = 100_000_000;

    static int start, target;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        list = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        dist = new int[N + 1];
        Arrays.fill(dist, INF);

        StringTokenizer st;
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[start].add(new GetNode(end, weight));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        dijkstra(start);

        bw.write(dist[target] + "");

        bw.flush();
        bw.close();
    }

    static void dijkstra(int start) {
        PriorityQueue<GetNode> q = new PriorityQueue<>();
        boolean[] check = new boolean[N + 1];
        q.add(new GetNode(start, 0));
        dist[start] = 0;

        while(!q.isEmpty()) {
            GetNode curNode = q.poll();
            int cur = curNode.end;

            if(check[cur]) {
                continue;
            }

            check[cur] = true;
            for(GetNode node : list[cur]) {
                if(dist[node.end] > dist[cur] + node.weight) {
                    dist[node.end] = dist[cur] + node.weight;
                    q.add(new GetNode(node.end, dist[node.end]));
                }
            }
        }
    }

}
class GetNode implements Comparable<GetNode> {
    int end;
    int weight;

    GetNode(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(GetNode o) {
        return weight - o.weight;
    }
}