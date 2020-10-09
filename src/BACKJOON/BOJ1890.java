package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ1890 {
    static int[] dirI = {0, 1};
    static int[] dirJ = {1, 0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];

        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][] dp = new long[n][n];
        dp[0][0] = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == n - 1 && j == n - 1) {
                    continue;
                }
                if(i + map[i][j] < n) {
                    dp[i + map[i][j]][j] += dp[i][j];
                }
                if(j + map[i][j] < n) {
                    dp[i][j + map[i][j]] += dp[i][j];
                }
            }
        }
        bw.write(dp[n - 1][n - 1] + "");
        bw.flush();
        bw.close();
    }
}