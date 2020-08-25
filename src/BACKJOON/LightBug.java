package BACKJOON;

import java.util.Scanner;

public class LightBug  {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int H = scan.nextInt();

        int[] s = new int[H + 1];
        int[] j = new int[H + 1];

        for(int i = 0; i < N; i++) {
            int h = scan.nextInt();
            if(i % 2 == 0) {
                s[h]++;
            }
            else {
                j[H - h + 1]++;
            }
        }

        int[] sSum = new int[H + 1];
        int[] jSum = new int[H + 1];

        for(int h = 1; h <= H; h++) {
            jSum[h] = jSum[h - 1] + j[h];
        }

        sSum[H] = s[H];
        for(int h = H - 1; h >= 1; h--) {
            sSum[h] = sSum[h + 1] + s[h];
        }

        int min = Integer.MAX_VALUE;
        int totalCount = 0;
        for(int h = 1; h <= H; h++) {
            int temp = sSum[h] + jSum[h];
            if(min == temp) {
                totalCount++;
            }
            if(min > temp) {
                min = temp;
                totalCount = 1;
            }
        }

        System.out.println(min + " " + totalCount);
    }
}
