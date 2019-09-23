/*
 * https://www.hackerrank.com/challenges/birthday-cake-candles/problem
 */

import java.util.*;
public class BirthdayCakeCandles {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        int max = Integer.MIN_VALUE;
        int maxNum = 0;

        for(int i = 0; i < num; i++) {
            int temp = scan.nextInt();
            if (temp > max) {
                max = temp;
                maxNum = 0;
            }
            if (temp == max) {
                maxNum++;
            }
        }

        System.out.print(maxNum);
    }
}