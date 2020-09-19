package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class ShortRoute {
    static int V, E, K;
    static int[] dist;
    static List<ShortRouteNode>[] list;
    static int INF = 100_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        K = Integer.parseInt(br.readLine());

        list = new ArrayList[V + 1];
        dist = new int[V + 1];
        Arrays.fill(dist, INF);

        for(int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[start].add(new ShortRouteNode(end, cost));
        }

        dijkstra(K);
        for(int i = 1; i <= V; i++) {
            if(dist[i] == INF) {
                bw.write("INF\n");
            }
            else {
                bw.write(dist[i] +"\n");
            }
        }

        bw.flush();
        bw.close();
    }

    static void dijkstra(int start) {
        PriorityQueue<ShortRouteNode> q = new PriorityQueue<>();
        boolean[] check = new boolean[V + 1];
        q.add(new ShortRouteNode(start, 0));
        dist[start] = 0;

        while(!q.isEmpty()) {
            ShortRouteNode curNode = q.poll();
            int cur = curNode.end;

            if(check[cur] == true) {
                continue;
            }

            check[cur] = true;
            for(ShortRouteNode node : list[cur]) {
                if(dist[node.end] > dist[cur] + node.weight) {
                    dist[node.end] = dist[cur] + node.weight;
                    q.add(new ShortRouteNode(node.end, dist[node.end]));
                }
            }
        }
    }
}

class ShortRouteNode implements Comparable<ShortRouteNode> {
    int end;
    int weight;

    ShortRouteNode(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(ShortRouteNode o) {
        return weight - o.weight;
    }
}