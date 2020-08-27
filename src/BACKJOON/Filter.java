package BACKJOON;

import java.util.Arrays;
import java.util.Scanner;

public class Filter {
    public static int[][] map;

    public static int[] dirI = {0, 0, 0, 1, 1, 1, 2, 2, 2};
    public static int[] dirJ = {0, 1, 2, 0, 1, 2, 0, 1, 2};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int R = scan.nextInt();
        int C = scan.nextInt();

        map = new int[R][C];
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                map[i][j] = scan.nextInt();
            }
        }

        int T = scan.nextInt();
        int answer = 0;
        for(int i = 0; i <= R - 3; i++) {
            for(int j = 0; j <= C - 3; j++) {
                int[] temp = new int[9];
                for(int index = 0; index < 9; index++) {
                    temp[index] = map[i + dirI[index]][j + dirJ[index]];
                }

                Arrays.sort(temp);
                if(temp[4] >= T) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
