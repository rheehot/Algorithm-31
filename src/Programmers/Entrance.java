package Programmers;

import java.util.Scanner;

public class Entrance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int index = scan.nextInt();
        int[] times = new int[index];
        for(int i = 0; i < index; i++) {
            times[index] = scan.nextInt();
        }
    }

    public static long solution (int n, int[] times) {
        long start = 1;
        long end = 0;
        for(long time : times) {
            if (end < time) {
                end = time;
            }
        }
        end *= n;

        long result = Long.MAX_VALUE;
        while(start <= end) {
            long middle = (start + end) / 2;
            long count = 0;
            for(long time : times) {
                count += middle / time;
            }

            if (count >= n) {
                if (result > middle) {
                    result = middle;
                }

                end = middle - 1;
            }
            else {
                start = middle + 1;
            }
        }
        return result;
    }
}
