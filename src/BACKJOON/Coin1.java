package BACKJOON;

import java.util.Scanner;

public class Coin1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int k = scan.nextInt();

        int[] coins = new int[n + 1];
        int[] dp = new int[k + 1];

        dp[0] = 1;
        for(int i = 1; i <= n; i++) {
            coins[i] = scan.nextInt();
        }

        for(int i = 1; i <= n; i++) {
            for(int j = coins[i]; j <= k; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }

        System.out.println(dp[k]);
    }
}
