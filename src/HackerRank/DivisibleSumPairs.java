package HackerRank;/*
 * https://www.hackerrank.com/challenges/divisible-sum-pairs/problem
 */

import java.util.*;
public class DivisibleSumPairs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int k = scan.nextInt();

        int[] ar = new int[n];
        for(int i = 0; i < n; i++) {
            ar[i] = scan.nextInt();
        }

        System.out.print(divisibleSumPairs(ar, k, n));
    }

    static int divisibleSumPairs(int[] ar, int k, int n) {
        int result = 0;

        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                int temp = ar[i] + ar[j];
                if (temp % k == 0) {
                    result++;
                }
            }
        }

        return result;
    }
}