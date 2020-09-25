package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ10942 {
    static int n;
    static int[] nums;
    static boolean[][] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        nums = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        dp = new boolean[n + 1][n + 1];
        getDp();

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if(dp[start][end]) {
                bw.write("1\n");
            }
            else {
                bw.write("0\n");
            }
        }

        bw.flush();
        bw.close();
    }

    public static void getDp() {
        for(int i = 1; i <= n; i++) {
            dp[i][i] = true;
        }

        for(int i = 1; i <= n - 1; i++) {
            if(nums[i] == nums[i + 1]) {
                dp[i][i + 1] = true;
            }
        }

        for(int j = 3; j <= n; j++) {
            for(int i = 1; i <= j - 2; i++) {
                if(nums[i] != nums[j]) {
                    dp[i][j] = false;
                    continue;
                }

                dp[i][j] = dp[i  +1][j - 1];
            }
        }
    }
}
