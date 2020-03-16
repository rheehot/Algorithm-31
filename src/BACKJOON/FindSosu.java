package BACKJOON;

import java.util.Scanner;

// 에라토스테네스의 체: 2부터 N까지 증가하는 i를 제외한 i의 배수를 하나하나 지워가면서 N까지 도달했을때 남은 수가 소수

public class FindSosu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int min = scan.nextInt();
        int max = scan.nextInt();

        boolean[] primeNum = new boolean[max + 1];
        primeNum[1] = true;

        for(int i = 2; i < primeNum.length; i++) {
            for(int j = 2; i * j < primeNum.length; j++) {
                primeNum[i * j] = true;
            }
        }

        for(int i = min; i <= max; i++) {
            if (!primeNum[i]) {
                System.out.println(i);
            }
        }
    }
}
