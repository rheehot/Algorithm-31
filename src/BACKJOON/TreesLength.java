package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class TreesLength {

    static List<TreesNode>[] list;
    static boolean[] visit;
    static TreesNode maxNode;
    static int max = 0, n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        visit = new boolean[n + 1];
        for(int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        list[0].add(new TreesNode(1, 0));
        for(int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split("\\s");
            int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[1]);
            int c = Integer.parseInt(tmp[2]);

            list[a].add(new TreesNode(b, c));
            list[b].add(new TreesNode(a, c));

            for(int j = 3; j < tmp.length; j += 2) {
                if(tmp[j].equals("-1")) {
                    break;
                }
                b = Integer.parseInt(tmp[j]);
                c = Integer.parseInt(tmp[j + 1]);
                list[a].add(new TreesNode(b, c));
                list[b].add(new TreesNode(a, c));
            }
        }

        TreesNode maxx = dfs(list[0].get(0), 0);
        visit = new boolean[n + 1];
        maxNode = null;
        max = 0;

        dfs(maxx, 0);

        bw.write(max+"");
        bw.flush();
        bw.close();
    }

    static TreesNode dfs(TreesNode v, int dist) {
        visit[v.node] = true;
        for(TreesNode temp : list[v.node]) {
            if(!visit[temp.node]) {
                dfs(temp, dist + temp.dist);
            }
        }

        if(max < dist) {
            maxNode = v;
            max = dist;
        }
        return maxNode;
    }
}
class TreesNode {
    int node, dist;

    TreesNode(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}
