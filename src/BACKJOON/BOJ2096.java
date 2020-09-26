package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2096 {
    static int[][] nums;
    static int[][] maxDp;
    static int[][] minDp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        nums = new int[n][3];
        maxDp = new int[n][3];
        minDp = new int[n][3];

        StringTokenizer st;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            nums[i][0] = Integer.parseInt(st.nextToken());
            nums[i][1] = Integer.parseInt(st.nextToken());
            nums[i][2] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++) {
            Arrays.fill(minDp[i], Integer.MAX_VALUE);
        }

        maxDp[0] = nums[0];
        minDp[0] = nums[0];

        for(int i = 0; i < n - 1; i++) {
            maxDp[i + 1][0] = Math.max(maxDp[i + 1][0], maxDp[i][0] + nums[i + 1][0]);
            maxDp[i + 1][1] = Math.max(maxDp[i + 1][1], maxDp[i][0] + nums[i + 1][1]);
            maxDp[i + 1][0] = Math.max(maxDp[i + 1][0], maxDp[i][1] + nums[i + 1][0]);
            maxDp[i + 1][1] = Math.max(maxDp[i + 1][1], maxDp[i][1] + nums[i + 1][1]);
            maxDp[i + 1][2] = Math.max(maxDp[i + 1][2], maxDp[i][1] + nums[i + 1][2]);
            maxDp[i + 1][1] = Math.max(maxDp[i + 1][1], maxDp[i][2] + nums[i + 1][1]);
            maxDp[i + 1][2] = Math.max(maxDp[i + 1][2], maxDp[i][2] + nums[i + 1][2]);

            minDp[i + 1][0] = Math.min(minDp[i + 1][0], minDp[i][0] + nums[i + 1][0]);
            minDp[i + 1][1] = Math.min(minDp[i + 1][1], minDp[i][0] + nums[i + 1][1]);
            minDp[i + 1][0] = Math.min(minDp[i + 1][0], minDp[i][1] + nums[i + 1][0]);
            minDp[i + 1][1] = Math.min(minDp[i + 1][1], minDp[i][1] + nums[i + 1][1]);
            minDp[i + 1][2] = Math.min(minDp[i + 1][2], minDp[i][1] + nums[i + 1][2]);
            minDp[i + 1][1] = Math.min(minDp[i + 1][1], minDp[i][2] + nums[i + 1][1]);
            minDp[i + 1][2] = Math.min(minDp[i + 1][2], minDp[i][2] + nums[i + 1][2]);
        }

        int max = Math.max(maxDp[n - 1][0], Math.max(maxDp[n - 1][1], maxDp[n - 1][2]));
        int min = Math.min(minDp[n - 1][0], Math.min(minDp[n - 1][1], minDp[n - 1][2]));
        bw.write(max + " " + min);
        bw.flush();
        bw.close();
    }
}
