package BACKJOON;

import java.util.Scanner;

public class TraseurIsland {
    public static int[][] map;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int M = scan.nextInt();
        int N = scan.nextInt();
        scan.nextLine();

        map = new int[M][N];
        for(int i = 0; i < M; i++) {
            String temp = scan.nextLine();
            for(int j = 0; j < N; j++) {
                if(temp.charAt(j) == 'W') {
                    map[i][j] = 1;
                }
            }
        }
        // 바다 = 1

        
    }
}
