package BACKJOON;

import java.util.Scanner;

public class NBigNumber {
    public static long[][] map;
    public static int[] index;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        map = new long[N][N];
        index = new int[N];

        for(int i = 0; i < N; i++) {
            index[i] = N - 1;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                map[i][j] = scan.nextLong();
            }
        }

        int count = 0;
        long answer = 0;
        while(true) {
            if(count == N) {
                break;
            }

            long max = map[index[0]][0];
            int maxIndex = 0;
            for(int j = 1; j < N; j++) {
                if(max < map[index[j]][j]) {
                    max = map[index[j]][j];
                    maxIndex = j;
                }
            }

            index[maxIndex]--;
            answer = max;
            count++;
        }

        System.out.println(answer);
    }
}
