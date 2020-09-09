package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CardGame {
    static int[] left;
    static int[] right;
    static int[][] dp;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        left = new int[N];
        right = new int[N];
        dp = new int[N][N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            left[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            right[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        bw.write(solution(0, 0) + "");

        bw.flush();
        bw.close();
    }

    static int solution(int l, int r) {
        if(l == N || r == N) {
            return 0;
        }

        if(dp[l][r] != -1) {
            return dp[l][r];
        }

        dp[l][r] = Math.max(solution(l + 1, r + 1), solution(l + 1, r));

        if(left[l] > right[r]) {
            dp[l][r] = Math.max(dp[l][r], solution(l, r + 1) + right[r]);
        }

        return dp[l][r];
    }
}
