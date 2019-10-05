package HackerRank;/*
 * https://www.hackerrank.com/challenges/staircase/problem
 */

import java.util.*;
public class Staircase {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        for(int i = 1; i <= n; i++) {
            for(int j = n - i; j > 0; j--) {
                System.out.print(" ");
            }
            for(int j = i; j >0; j--) {
                System.out.print("#");
            }
            System.out.println();
        }
    }
}