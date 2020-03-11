package BACKJOON;

import java.util.Scanner;

public class BeeHouse {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        // 1: 1     (1개)
        // 2~7: 2   (6개)
        // 8~19: 3  (12개)
        // 20~37: 4 (18개)
        // 38~61: 5 (24개)

        int result = 1;
        int diff = 0;

        while(true) {
            if (6 * diff + 1 >= N) {
                break;
            }
            diff += result;
            result++;
        }

        System.out.println(result);

    }
}
