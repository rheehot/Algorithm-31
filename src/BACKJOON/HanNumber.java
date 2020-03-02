package BACKJOON;

import java.util.*;

public class HanNumber {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        han(n);
    }

    public static void han(int n) {
        if (n < 100) {
            System.out.println(n);
            return;
        }

        int result = 99;

        for(int i = 100; i <= n; i++) {
            int temp = i;
            int desc = (temp % 10) - (temp / 10) % 10;

            boolean yes = true;
            while(temp >= 10) {
                int first = temp % 10;
                int second = (temp / 10) % 10;

                if(first - second != desc) {
                    yes = false;
                    break;
                }

                temp /= 10;
            }

            if (yes) {
                result += 1;
            }
        }

        System.out.println(result);

    }
}
