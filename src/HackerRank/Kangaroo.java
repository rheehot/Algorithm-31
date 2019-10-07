package HackerRank;

/*
 * https://www.hackerrank.com/challenges/kangaroo/problem
 */

import java.util.*;
public class Kangaroo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int x1 = scan.nextInt();
        int v1 = scan.nextInt();
        int x2 = scan.nextInt();
        int v2 = scan.nextInt();

        int x = x2 - x1;
        int v = v1 - v2;

        if (x <= 0 || v <= 0) {
            System.out.println("NO");
        }
        else if (x % v == 0) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
}