package src.HackerRank;
/*
 * https://www.hackerrank.com/challenges/bon-appetit/problem
 */

import java.util.*;
public class BonAppetit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int k = scan.nextInt();

        int[] bill = new int[n];
        for(int i = 0; i < n; i ++) {
            bill[i] = scan.nextInt();
        }

        int b = scan.nextInt();

        int result = bonAppetit(bill, k, b);
        if (result == 0) {
            System.out.print("Bon Appetit");
        }
        else {
            System.out.print(result);
        }
    }

    static int bonAppetit(int[] bill, int k, int b) {
        int sum = 0;
        for(int i = 0; i < bill.length; i++) {
            if (i == k) {
                continue;
            }
            sum += bill[i];
        }
        sum /= 2;

        return (b - sum);
    }
}