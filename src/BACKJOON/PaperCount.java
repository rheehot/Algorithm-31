package BACKJOON;

import java.util.Scanner;

public class PaperCount {
    public static int[][] map;
    // 0 -> -1
    public static int[] answer = new int[3];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        map = new int[N + 1][N + 1];

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                map[i][j] = scan.nextInt();
            }
        }

        solution(1, N, 1, N);

        for(int i = 0; i < 3; i++) {
            System.out.println(answer[i]);
        }
    }

    public static void solution(int startI, int endI, int startJ, int endJ) {
        if(judge(startI, endI, startJ, endJ)) {
            answer[map[startI][startJ] + 1]++;
            return;
        }

        int diffI = ((endI - startI + 1) / 3);
        int diffJ = ((endJ - startJ + 1) / 3);

        for(int i = 0; i < 3; i++) {
            int tempStartI = startI + (diffI * i);
            int tempEndI = tempStartI + diffI - 1;
            for(int j = 0; j < 3; j++) {
                int tempStartJ = startJ + (diffJ * j);
                int tempEndJ = tempStartJ + diffJ - 1;

                solution(tempStartI, tempEndI, tempStartJ, tempEndJ);
            }
        }
    }

    public static boolean judge(int startI, int endI, int startJ, int endJ) {
        int target = map[startI][startJ];
        for(int i = startI; i <= endI; i++) {
            for(int j = startJ; j <= endJ; j++) {
                if(target != map[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
