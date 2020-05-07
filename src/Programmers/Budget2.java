package Programmers;

import java.util.Arrays;
import java.util.Scanner;

public class Budget2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] budgets = new int[n];

        for(int i = 0; i < n; i++) {
            budgets[i] = scan.nextInt();
        }
        int M = scan.nextInt();

        System.out.println(solution(budgets, M));
    }

    public static int solution(int[] budgets, int M) {
        int start = 0;
        int end = Arrays.stream(budgets).max().getAsInt();
        int result = 0;
        while(start <= end) {
            int middle = (start + end) / 2;
            int sum = 0;
            for(int b : budgets) {
                if (b < middle) {
                    sum += b;
                }
                else {
                    sum += middle;
                }
            }

            if (sum > M) {
                end = middle - 1;
            }
            else {
                result = middle;
                start = middle + 1;
            }
        }

        return result;
    }
}
