package BACKJOON;

import java.util.Scanner;

public class CroatiaAlpha {

    static String[] croatia = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        for(int i = 0; i < croatia.length; i++) {
            if(str.contains(croatia[i])) {
                str = str.replaceAll(croatia[i], "*");
            }
        }

        System.out.println(str.length());
    }
}
