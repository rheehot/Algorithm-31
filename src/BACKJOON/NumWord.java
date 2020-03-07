package BACKJOON;

import java.util.Scanner;

public class NumWord {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] str = scan.nextLine().split(" ");
        int result = str.length;

        for(int i = 0; i < result; i++) {
            if(str[i].equals("")) {
                result--;
            }
        }
        System.out.println(result);
    }
}
