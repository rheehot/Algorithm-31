package HackerRank;/*
 * https://www.hackerrank.com/challenges/apple-and-orange/problem
 */

import java.util.*;
public class AppleAndOrange {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int start = scan.nextInt();
        int end = scan.nextInt();

        int aStart = scan.nextInt();
        int oStart = scan.nextInt();

        int aNum = scan.nextInt();
        int oNum = scan.nextInt();

        int aResult = 0;
        for (int i = 0; i < aNum; i++) {
            int aTemp = scan.nextInt();

            aTemp += aStart;
            if (aTemp >= start && aTemp <= end) {
                aResult++;
            }
        }

        int oResult = 0;
        for (int i = 0; i < oNum; i++) {
            int oTemp = scan.nextInt();

            oTemp += oStart;
            if(oTemp >= start && oTemp <= end) {
                oResult++;
            }
        }

        System.out.println(aResult);
        System.out.println(oResult);
    }
}