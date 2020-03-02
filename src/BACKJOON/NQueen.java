package BACKJOON;

import java.util.Scanner;

public class NQueen {

    static int result = 0;

    static int[] iDir = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] jDir = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        System.out.print(n);

        boolean[][] visit = new boolean[n][n];
        takeQueen(visit, n, 0);
    }

    public static void takeQueen(boolean[][] visit, int targetQ, int curQ) {

        if (curQ >= targetQ) {
            result++;
            return;
        }

        for(int i = 0; i < targetQ; i++) {
            for(int j = 0; j < targetQ; j++) {
                if (visit[i][j]) {
                    continue;
                }
                visit[i][j] = true;
                for(int d = 0; d < 8; d++) {

                }
                visit[i][j] = false;
            }
        }
    }

    public static boolean[][] visitQueen(boolean[][] visit, int dir) {
        return visit;
    }
}
