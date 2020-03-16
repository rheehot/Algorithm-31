package BACKJOON;

import java.util.Scanner;

public class Fly {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int T = scan.nextInt();
        for(int i = 0; i < T; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();

            System.out.println(getMinMove(y - x));
        }
    }

    public static int getMinMove(int n) {
        // i: n 제곱근의 올림값
        // i * i - i 보다 클 경우 2 * i - 1
        // i * i - i 보다 작을 경우 2 * i - 2

        int i = (int) Math.ceil(Math.sqrt(n));
        if(n > i * i - i) {
            return 2 * i - 1;
        } else {
            return 2 * i - 2;
        }
    }
}
