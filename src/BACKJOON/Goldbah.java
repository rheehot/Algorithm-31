package BACKJOON;

import java.util.Scanner;

public class Goldbah {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        boolean[] primeNum = new boolean[10001];
        primeNum[1] = true;
        for(int i = 2; i < primeNum.length; i++) {
            for(int j = 2; i * j < primeNum.length; j++) {
                primeNum[i * j] = true;
            }
        }

        int T = scan.nextInt();
        for(int i = 0; i < T; i++) {
            int n = scan.nextInt();
            int min = 0;
            int max = 0;
            int diff = 0;

            for(int j = 2; j <= n / 2; j++) {
                if (!primeNum[j] && !primeNum[n - j]) {
                    if (min == 0 && max == 0) {
                        min = j;
                        max = n - j;
                        diff = max - min;
                    } else {
                        if (diff > (n - j) - j) {
                            min = j;
                            max = n - j;
                            diff = max - min;
                        }
                    }
                }
            }

            System.out.println(min + " " + max);
        }
    }
}
