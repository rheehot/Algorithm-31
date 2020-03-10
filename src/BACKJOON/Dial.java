package BACKJOON;

import java.util.Scanner;

public class Dial {
    static int[] sec =  {3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 10, 10, 10, 10};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String word = scan.next();

        int result = 0;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'A';

            result += sec[index];
        }

        System.out.println(result);
    }
}
