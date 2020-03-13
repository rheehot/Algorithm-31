package BACKJOON;

import java.util.Scanner;

public class Bunyu {
    public static void main(String[] args) {
        Scanner scan =  new Scanner(System.in);
        int T = scan.nextInt();

        for(int i = 0; i < T; i++) {
            int k = scan.nextInt();
            int n = scan.nextInt();

            if (k == 0) {
                System.out.println(n);
                continue;
            }
            if (n == 1) {
                System.out.println(1);
                continue;
            }

            int[][] apt = new int[k + 1][n + 1];
            for(int f = 0; f <= k; f++) {
                for(int r = 1; r <= n; r++) {
                    if (r == 1) {
                        apt[f][r] = 1;
                        continue;
                    }
                    if (f == 0) {
                        apt[f][r] = r;
                        continue;
                    }

                    apt[f][r] = apt[f][r - 1] + apt[f - 1][r];
                }
            }
            System.out.println(apt[k][n]);
        }
    }
}
