package BACKJOON;

import java.util.Scanner;

public class Sosu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int count = 0;

        for(int i = 0; i < N; i++) {
            int num = scan.nextInt();

            if (num <= 1) {
                continue;
            }

            boolean sosu = true;
            for(int j = 2; j <= num / 2; j++) {
                if (num % j == 0) {
                    sosu = false;
                    break;
                }
            }
            if (sosu) {
                count++;
            }
        }
        System.out.println(count);
    }
}
