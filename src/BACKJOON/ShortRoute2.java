package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class ShortRoute2 {
    static int V, E, start;
    static int[] dist;
    static List<ShortNode>[] list;
    static int INF = 100_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());

        dist = new int[V + 1];
        list = new ArrayList[V + 1];
        Arrays.fill(dist, INF);

        for(int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[start].add(new ShortNode(end, weight));
        }

        dijkstra(start);

        bw.flush();
        bw.close();
    }

    static void dijkstra(int start) {
        PriorityQueue<ShortNode> q = new PriorityQueue<>();
        boolean[] check = new boolean[V + 1];
        q.add(new ShortNode(start, 0));
        dist[start] = 0;

        while(!q.isEmpty()) {
            ShortNode curNode = q.poll();
            int cur = curNode.end;

            if(check[cur] == true) {
                continue;
            }

            check[cur] = true;
            for(ShortNode node : list[cur]) {
                if(dist[node.end] > dist[cur] + node.weight) {
                    dist[node.end] = dist[cur] + node.weight;
                    q.add(new ShortNode(node.end, dist[node.end]));
                }
            }
        }
    }

}

class ShortNode implements Comparable<ShortNode> {
    int end;
    int weight;

    ShortNode(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(ShortNode o) {
        return weight - o.weight;
    }
}
