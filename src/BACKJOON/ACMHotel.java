package BACKJOON;

import java.util.Scanner;

public class ACMHotel {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for(int i = 0; i < T; i++) {
            int H = scan.nextInt();
            int W = scan.nextInt();
            int N = scan.nextInt();

            int f = N % H;
            int r = (N / H) + 1;
            if (f == 0) {
                r--;
                f = H;
            }
            System.out.println((f * 100) + r);
        }
    }
}
