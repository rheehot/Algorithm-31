package BACKJOON;

import java.util.Scanner;

public class DeliverySugar {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        int result = -1;
        for(int i = N / 5; i >= 0; i--) {
            int tempSugar = N - (i * 5);
            if (tempSugar % 3 == 0) {
                result = i + (tempSugar / 3);
                break;
            }
        }

        System.out.println(result);
    }
}
