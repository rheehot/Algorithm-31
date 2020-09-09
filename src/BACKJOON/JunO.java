package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class JunO {
    static List<JunONode>[] list;
    static boolean[] visit;
    static int maxCount = 0;
    static JunONode maxNode;
    static int minCost = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        for(int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        list[0].add(new JunONode(1, 0));

        for(int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            list[A].add(new JunONode(B, C));
            list[B].add(new JunONode(A, C));
        }

        visit[1] = true;
        JunONode maxx = dfs(list[0].get(0), 0, 0);
        visit = new boolean[N + 1];
        maxNode = null;
        maxCount = 0;
        minCost = 0;

        visit[maxx.node] = true;
        dfs(maxx, 0, 0);

        int answer = minCost / T;
        if(minCost % T != 0) {
            answer++;
        }

        bw.write( answer+"");
        bw.flush();
        bw.close();
    }

    static JunONode dfs(JunONode v, int dist, int count) {

        if(maxCount < count) {
            maxCount = count;
            minCost = dist;
            maxNode = v;
        }
        else if (maxCount == count) {
            if(minCost > dist) {
                minCost = dist;
                maxNode = v;
            }
        }

        for(JunONode temp : list[v.node]) {
            if(!visit[temp.node]) {
                visit[temp.node] = true;
                dfs(temp, dist + temp.dist, count + 1);
            }
        }
        return maxNode;
    }
}

class JunONode {
    int node,dist;

    JunONode(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}