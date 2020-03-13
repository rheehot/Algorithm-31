package BACKJOON;

import java.util.Scanner;

public class SosuTwo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int minNum = scan.nextInt();
        int maxNum = scan.nextInt();

        int minResult = -1;
        long sumResult = 0;
        for(int i = minNum; i <= maxNum; i++) {
            if (i < 2) {
                continue;
            }
            if(i == 2) {
                minResult = i;
                sumResult += i;
                continue;
            }

            boolean sosu = true;
            for(int j = 2; j < i; j++) {
                if (i % j == 0) {
                    sosu = false;
                    break;
                }
            }
            if(sosu) {
                if (minResult < 0) {
                    minResult = i;
                }
                sumResult += i;
            }
        }

        if (minResult < 0) {
            System.out.println(minResult);
        }
        else {
            System.out.println(sumResult);
            System.out.println(minResult);
        }
    }
}
