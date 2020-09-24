package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class FirstGrade {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long[][] dp = new long[N - 1][21];
        dp[0][arr[0]] = 1;
        for(int i = 1; i < N - 1; i++){
            for(int j = 0; j < 21; j++){
                if(dp[i - 1][j] != 0) {
                    if(j + arr[i] <= 20) dp[i][j + arr[i]] += dp[i - 1][j];
                    if(j - arr[i] >= 0) dp[i][j - arr[i]] += dp[i - 1][j];
                }
            }
        }
        bw.write(dp[N - 2][arr[N - 1]] + "\n");

        bw.flush();
        br.close();
    }
}
