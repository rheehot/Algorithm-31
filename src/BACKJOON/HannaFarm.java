package BACKJOON;

import java.util.Scanner;

public class HannaFarm {
    public static int[][] map;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int T = scan.nextInt();
        for(int i = 0; i < T; i++) {
            int M = scan.nextInt();
            int N = scan.nextInt();
            int K = scan.nextInt();

            map = new int[N][M];

            for(int j = 0; j < K; j++) {
                int indexJ = scan.nextInt();
                int indexI = scan.nextInt();

                map[indexI][indexJ] = 1;
            }

            if(K == 1) {
                System.out.println(1);
            }
            else {
                solution(M, N);
            }
        }
    }

    public static int[] dirI = {-1, 0, 1, 0};
    public static int[] dirJ = {0, 1, 0, -1};
    public static boolean[][] visit;
    public static int count;

    public static void solution(int M, int N) {
        visit = new boolean[N][M];
        count = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 1 && !visit[i][j]) {
                    count++;
                    visit[i][j] = true;
                    judge(i, j);
                }
            }
        }
        System.out.println(count);
    }

    public static void judge( int i, int j) {
        for(int index = 0; index < 4; index++) {
            int nI = i + dirI[index];
            int nJ = j + dirJ[index];

            if(nI >= 0 && nJ >= 0 && nI < map.length && nJ < map[0].length && map[nI][nJ] == 1 && !visit[nI][nJ]) {
                visit[nI][nJ] = true;
                judge(nI, nJ);
            }
        }
    }
}
