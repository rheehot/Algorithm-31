package BACKJOON;

import java.util.Arrays;
import java.util.Scanner;

public class SortInside {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();

        int[] num = new int[str.length()];
        for(int i = 0; i < str.length(); i++) {
            num[i] = str.charAt(i) - '0';
        }

        Arrays.sort(num);

        for(int i = str.length() - 1; i >= 0; i--) {
            System.out.print(num[i]);
        }
    }
}
