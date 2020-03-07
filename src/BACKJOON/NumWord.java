package BACKJOON;

import java.util.Scanner;

public class NumWord {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();

        String[] result = str.split(" ");
        System.out.println(result.length);
    }
}
