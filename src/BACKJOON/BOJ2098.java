package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2098 {
    static int INF = 987654321;
    static int n;
    static int[][] map;
    static int[][] visit;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        visit = new int[n][1 << n];
        map = new int[n][n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++) {
            Arrays.fill(visit[i], -1);
        }

        bw.write(dfs(0, 1) + "");
        bw.flush();
        bw.close();
    }

    public static int dfs(int current, int visited) {
        if(visited == (1 << n) - 1) {
            if(map[current][0] != 0) {
                return map[current][0];
            }
            return INF;
        }

        if(visit[current][visited] >= 0) {
            return visit[current][visited];
        }

        int min = INF;
        for(int i = 0; i < n; i++) {
            if((visited & (1 << i)) == 0 && map[current][i] != 0) {
                int dis = dfs(i, visited | (1 << i)) + map[current][i];
                min = Math.min(dis, min);
            }
        }

        visit[current][visited] = min;
        return visit[current][visited];
    }
}