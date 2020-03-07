package BACKJOON;

import java.util.Scanner;

public class StudyWord {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine().toLowerCase();

        int[] alpha = new int[26];

        for(int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'a';
            alpha[index]++;
        }
        int maxNum = 0;
        char result = '?';
        for(int i = 0; i < alpha.length; i++) {
            if (maxNum == alpha[i]) {
                result = '?';
            }
            if (maxNum < alpha[i]) {
                maxNum = alpha[i];
                result = (char) (i + 'a');
            }
        }

        System.out.println(Character.toUpperCase(result));
    }
}
