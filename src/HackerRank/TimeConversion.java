package HackerRank;/*
 * https://www.hackerrank.com/challenges/time-conversion/problem
 */

import java.util.*;
public class TimeConversion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String origin = scan.nextLine();
        boolean isAM = false;

        if (origin.substring(origin.length() - 2, origin.length()).equals("AM")) {
            isAM = true;
        }

        origin = origin.substring(0, 8);
        String[] time = origin.split(":");
        if (isAM) {
            if (time[0].equals("12")) {
                System.out.print("00");
                System.out.print(":");
                System.out.print(time[1]);
                System.out.print(":");
                System.out.print(time[2]);
            }
            else {
                System.out.print(origin);
            }
        }
        else {
            int temp = Integer.valueOf(time[0]);
            if (temp != 12) {
                temp += 12;
            }
            System.out.print(temp);
            System.out.print(":");
            System.out.print(time[1]);
            System.out.print(":");
            System.out.print(time[2]);
        }
    }
}