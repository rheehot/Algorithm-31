package src.HackerRank;

/*
 * https://www.hackerrank.com/challenges/the-birthday-bar/problem
 */

import java.util.*;
public class BirthdayChocolate {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int[] chocolates = new int[num];

        for(int i = 0; i < num; i++) {
            chocolates[i] = scan.nextInt();
        }

        int day = scan.nextInt();
        int month = scan.nextInt();

        System.out.println(birthday(chocolates, day, month));
    }

    public static int birthday(int[] chocolate, int d, int m) {
        int result = 0;

        for(int i = 0; i <= chocolate.length - m; i++) {
            int temp_sum = 0;
            for (int j = 0; j < m; j++) {
                temp_sum += chocolate[i + j];
            }
            if (temp_sum == d) {
                result++;
            }
        }

        return result;
    }
}