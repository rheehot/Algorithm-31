package BACKJOON;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AvoidFood {
    public static int N;
    public static int M;

    public static boolean[][] map;
    public static boolean[][] visit;
    public static int answer = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();
        M = scan.nextInt();

        map = new boolean[N + 1][M + 1];
        visit = new boolean[N + 1][M + 1];

        int K = scan.nextInt();
        for(int i = 0; i < K; i++) {
            map[scan.nextInt()][scan.nextInt()] = true;
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                if(map[i][j] && !visit[i][j]) {
                    solution(i, j);
                }
            }
        }

        System.out.println(answer);
    }

    public static int[] dirI = {0, 0, 1, -1};
    public static int[] dirJ = {1, -1, 0, 0};

    public static void solution(int i, int j) {
        int count = 0;
        Queue<AvoidFoodIndex> q = new LinkedList<>();
        q.offer(new AvoidFoodIndex(i, j));
        visit[i][j] = true;

        while(!q.isEmpty()) {
            AvoidFoodIndex temp = q.poll();
            count++;

            for(int index = 0; index < 4; index++) {
                int tempI = temp.i + dirI[index];
                int tempJ = temp.j + dirJ[index];

                if(tempI < 1 || tempJ < 1 || tempI > N || tempJ > M) {
                    continue;
                }
                if(map[tempI][tempJ] && !visit[tempI][tempJ]) {
                    q.offer(new AvoidFoodIndex(tempI, tempJ));
                    visit[tempI][tempJ] = true;
                }
            }
        }

        if(count > answer) {
            answer = count;
        }
    }
}

class AvoidFoodIndex {
    int i;
    int j;

    AvoidFoodIndex(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
