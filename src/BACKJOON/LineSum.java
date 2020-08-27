package BACKJOON;

import java.util.Scanner;

public class LineSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] nums = new int[N];
        for(int i = 0; i < N; i++) {
            nums[i] = scan.nextInt();
        }

        int[] dp = new int[N];
        dp[0] = nums[0];
        int max = dp[0];
        for(int i = 1; i < N; i++) {
            if(dp[i - 1] + nums[i] > nums[i]) {
                dp[i] = dp[i - 1] + nums[i];
            }
            else {
                dp[i] = nums[i];
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
