package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ1495 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] diff = new int[n];
        for(int index = 0; index < n; index++) {
            diff[index] = Integer.parseInt(st.nextToken());
        }

        boolean[][] dp = new boolean[n + 1][max + 1];
        dp[0][start] = true;
        for(int i = 0; i < n; i++) {
            boolean flag = true;
            for(int j = 0; j <= max; j++) {
                if(dp[i][j]) {
                    flag = false;

                    int small = j - diff[i];
                    int big = j + diff[i];

                    if(small >= 0) {
                        dp[i + 1][small] = true;
                    }
                    if(big <= max) {
                        dp[i + 1][big] = true;
                    }
                }
            }
            if(flag) {
                break;
            }
        }

        int answer = -1;
        for(int j = max; j >= 0; j--) {
            if (dp[n][j]) {
                answer = j;
                break;
            }
        }
        bw.write(answer + "");
        bw.flush();
        bw.close();
    }
}
