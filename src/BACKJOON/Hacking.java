package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Hacking {
    static int n, d, c;
    static List<HackingNode>[] list;
    static int[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            list = new ArrayList[n + 1];
            dist = new int[n + 1];
            for(int i = 1; i <= n; i++) {
                list[i] = new ArrayList<>();
            }

            for(int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                list[b].add(new HackingNode(a, s));
            }

            solution(c);
            int second = 0;
            int count = 0;
            for(int i = 1; i <= n; i++) {
                if(dist[i] != INF) {
                    count++;
                }
                if(dist[i] != INF && second < dist[i]) {
                    second = dist[i];
                }
            }

            bw.write(count + " " + second + "\n");
        }

        bw.flush();
        bw.close();
    }

    static int INF = 100_000_000;
    static void solution(int start) {
        Queue<HackingNode> q = new LinkedList<>();
        q.add(new HackingNode(start, 0));

        Arrays.fill(dist, INF);
        dist[start] = 0;

        while(!q.isEmpty()) {
            HackingNode curNode = q.poll();
            int curCom = curNode.computer;

            for(HackingNode node : list[curCom]) {
                if(dist[node.computer] > dist[curNode.computer] + node.second) {
                    dist[node.computer] = dist[curNode.computer] + node.second;
                    q.add(new HackingNode(node.computer, dist[node.computer]));
                }
            }
        }
    }
}
class HackingNode {
    int computer;
    int second;

    HackingNode(int computer, int second) {
        this.computer = computer;
        this.second = second;
    }
}
