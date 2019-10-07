package HackerRank;

/*
 * https://www.hackerrank.com/challenges/day-of-the-programmer/problem
 */


import java.util.*;
public class DayOfTheProgrammer {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int year = scan.nextInt();
        System.out.print(dayOfProgrammer(year));
    }

    static String dayOfProgrammer(int year) {
        String result = "";

        boolean isLeap = (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))? true : false;

        if (year < 1918) {
            if (year % 4 == 0) {
                isLeap = true;
            }
            else {
                isLeap = false;
            }
        }

        if (isLeap) {
            result += "12.09.";
            result += year;
        }
        else {
            result += "13.09.";
            result += year;
        }

        if(year == 1918) {
            result = "26.09.1918";
        }

        return result;
    }
}