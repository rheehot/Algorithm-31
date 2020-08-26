package BACKJOON;

import java.util.Arrays;
import java.util.Scanner;

public class EmployeeGanho {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int[] tip = new int[N];
        for(int i = 0; i < N; i++) {
            tip[i] = scan.nextInt();
        }

        Arrays.sort(tip);

        long sum = 0;
        for(int i = 0; i < N; i++) {
            int temp = tip[N - i - 1] - ((i + 1) - 1);
            if(temp < 0) {
                break;
            }
            sum += temp;
        }
        System.out.println(sum);
    }
}
