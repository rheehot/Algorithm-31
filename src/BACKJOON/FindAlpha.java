package BACKJOON;

import java.util.Scanner;

public class FindAlpha {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();

        int[] alpha = new int[26];
        for(int i = 0; i < alpha.length; i++) {
            alpha[i] = -1;
        }

        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int index = c - 'a';

            if (alpha[index] == -1) {
                alpha[index] = i;
            }
        }

        for(int i = 0; i < alpha.length; i++) {
            System.out.print(alpha[i] + " ");
        }
    }
}
