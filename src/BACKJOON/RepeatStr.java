package BACKJOON;

import java.util.Scanner;

public class RepeatStr {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int T = scan.nextInt();
        int[] num = new int[T];
        String[] str = new String[T];

        for(int i = 0; i < T; i++) {
            num[i] = scan.nextInt();
            str[i] = scan.next();
        }

        for(int i = 0; i < T; i++) {
            int number = num[i];
            String s = str[i];

            for(int j = 0; j < s.length(); j++) {
                for(int k = 0; k < number; k++) {
                    System.out.print(s.charAt(j));
                }
            }
            System.out.println();
        }
    }
}
