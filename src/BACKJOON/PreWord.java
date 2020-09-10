package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PreWord {
    static String[] strs;
    static int answer = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        strs = new String[N + 1];
        for(int i = 1; i <= N; i++) {
            strs[i] = br.readLine();
        }

        int[][] dp = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(i == j) {
                    dp[i][j] = dp[i][j - 1];
                    continue;
                }

                if(judge(strs[i], strs[j])) {
                    dp[i][j] = dp[i][j - 1] + 1;
                }
                else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
            answer = Math.max(answer, dp[i][N]);
            for(int j = 1; j <= N; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        bw.write(answer +"");
        bw.flush();
        bw.close();
    }

    public static boolean judge(String one, String two) {
        if(one.length() > two.length()) {
            // 접두사
            if(two.equals(one.substring(0, two.length()))) {
                return false;
            }
            else {
                return true;
            }
        }
        else {
            if(one.equals(two.substring(0, one.length()))) {
                return false;
            }
            else {
                return true;
            }
        }
    }
}