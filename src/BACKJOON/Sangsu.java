package BACKJOON;

import java.util.Scanner;

public class Sangsu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] numbers = scan.nextLine().split(" ");
        int max = 0;
        for(int i = 0; i < numbers.length; i++) {
            if (numbers[i].equals("")) {
                continue;
            }
            String temp = numbers[i];
            temp = reverseStr(temp);

            if (max < Integer.parseInt(temp)) {
                max = Integer.parseInt(temp);
            }
        }

        System.out.println(max);

    }

    public static String reverseStr(String s) {
        return (new StringBuffer(s)).reverse().toString();
    }
}
