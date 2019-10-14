package src.HackerRank;

/*
 * https://www.hackerrank.com/challenges/grading/problem
 */

import java.util.*;
public class GradingStudents {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        int[] grades = new int[num];
        for(int i = 0; i < num; i++) {
            int temp = scan.nextInt();
            if (temp < 38) {
                grades[i] = temp;
            }
            else {
                int ttemp = temp / 5;
                ttemp++;
                ttemp *= 5;
                if (ttemp - temp < 3) {
                    temp = ttemp;
                }
                grades[i] = temp;
            }
        }

        for(int i = 0; i < num; i++) {
            System.out.println(grades[i]);
        }
    }
}