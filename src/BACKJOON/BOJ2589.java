package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2589 {
    static int n, m;
    static int[][] map;
    static int max = 0;
    static boolean[][] visit;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j = 0; j < m; j++) {
                char t = str.charAt(j);
                if(t == 'W') {
                    map[i][j] = 1;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 0) {
                    visit = new boolean[n][m];
                    int val = bfs(i, j);
                    max = Math.max(max, val);
                }
            }
        }

        bw.write(max + "");

        bw.flush();
        bw.close();
    }

    static int[] dirI = {0, 0, 1, -1};
    static int[] dirJ = {1, -1, 0, 0};
    public static int bfs(int i, int j) {
        Queue<TrasureNode> q = new LinkedList<>();
        int val = 0;
        visit[i][j] = true;
        q.add(new TrasureNode(i, j, 0));
        while(!q.isEmpty()) {
            TrasureNode temp = q.poll();
            for(int index = 0; index < 4; index++) {
                int nextI = temp.i + dirI[index];
                int nextJ = temp.j + dirJ[index];
                if(nextI < 0 || nextI >= n || nextJ < 0 || nextJ >= m || visit[nextI][nextJ] || map[nextI][nextJ] == 1) {
                    continue;
                }

                visit[nextI][nextJ] = true;
                q.add(new TrasureNode(nextI, nextJ, temp.count + 1));
                val = Math.max(val, temp.count + 1);
            }
        }

        return val;
    }
}
class TrasureNode {
    int i;
    int j;
    int count;

    TrasureNode(int i, int j, int count) {
        this.i = i;
        this.j = j;
        this.count = count;
    }
}
