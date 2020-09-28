package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ1309 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][3];
        Arrays.fill(dp[1], 1);

        for(int i = 2; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2];
            dp[i][1] = dp[i - 1][0] + dp[i - 1][2];
            dp[i][2] = dp[i - 1][0] + dp[i - 1][1];

            dp[i][0] %= 9901;
            dp[i][1] %= 9901;
            dp[i][2] %= 9901;
        }

        int answer = dp[n][0] + dp[n][1] + dp[n][2];
        answer %= 9901;

        bw.write(answer + "");
        bw.flush();
        bw.close();
    }


}
