package BACKJOON;

import java.util.Scanner;

public class Bertrang {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean[] primeNum = new boolean[123456 * 2 + 1];
        primeNum[1] = true;
        for(int i = 2; i < primeNum.length; i++) {
            for(int j = 2; i * j < primeNum.length; j++) {
                primeNum[i * j] = true;
            }
        }

        while(true) {
            int n = scan.nextInt();
            if (n == 0) {
                break;
            }

            int num = 0;
            for(int i = n + 1; i <= n * 2; i++) {
                if (!primeNum[i]) {
                    num++;
                }
            }
            System.out.println(num);
        }
    }
}
