/*
 * https://www.hackerrank.com/challenges/mini-max-sum/problem
 */

import java.util.*;
public class MiniMaxSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        long sum = 0;
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        for(int i = 0; i < 5; i++) {
            long num = scan.nextLong();
            sum += num;

            if (min > num) {
                min = num;
            }
            if (max < num) {
                max = num;
            }
        }

        System.out.println((sum - max) + " " + (sum - min));
    }
}