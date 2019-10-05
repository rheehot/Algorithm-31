package HackerRank;/*
 * https://www.hackerrank.com/challenges/diagonal-difference/problem
 */

import java.util.*;
public class DiagonalDifference {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        int[][] array = new int[num][num];
        for(int i = 0; i < num; i++) {
            for(int j = 0; j < num; j++) {
                array[i][j] = scan.nextInt();
            }
        }

        int right = 0;
        int left = 0;
        for(int i = 0; i < num; i++) {
            right += array[i][i];
            left += array[i][num - i - 1];
        }

        System.out.println(Math.abs(right - left));
    }
}