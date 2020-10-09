package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ11048 {
    static int n, m;
    static int[][] map;
    static int[][] candy;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        candy = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        candy[0][0] = map[0][0];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(i + 1 < n) {
                    candy[i + 1][j] = Math.max(candy[i + 1][j], candy[i][j] + map[i + 1][j]);
                }
                if(j + 1 < m) {
                    candy[i][j + 1] = Math.max(candy[i][j + 1], candy[i][j] + map[i][j + 1]);
                }
                if(i + 1 < n && j + 1 < m) {
                    candy[i + 1][j + 1] = Math.max(candy[i + 1][j + 1], candy[i][j] + map[i + 1][j + 1]);
                }
            }
        }

        bw.write(candy[n - 1][m - 1] + "");
        bw.flush();
        bw.close();
    }
}
