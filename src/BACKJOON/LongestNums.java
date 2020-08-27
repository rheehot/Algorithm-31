package BACKJOON;

import java.util.Scanner;

public class LongestNums {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] nums = new int[N];

        for(int i = 0; i < N; i++) {
            nums[i] = scan.nextInt();
        }

        int[] dp = new int[N];
        dp[0] = 1;
        int max = 1;
        for(int i = 1; i < N; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                }
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
