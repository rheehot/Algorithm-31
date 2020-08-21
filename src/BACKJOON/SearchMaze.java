package BACKJOON;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SearchMaze {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int M = scan.nextInt();
        scan.nextLine();

        int[][] map = new int[N][M];

        for(int i = 0; i < N; i++) {
            String temp = scan.nextLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = temp.charAt(j) - '0';
            }
        }

        System.out.println(solution(N, M, map));
    }

    public static int[] dirI = {0, 0, 1, -1};
    public static int[] dirJ = {1, -1, 0, 0};

    public static int solution(int N, int M, int[][] map) {

        int[][] visit = new int[N][M];
        Queue<MazeIndex> q = new LinkedList<>();

        MazeIndex start = new MazeIndex(0, 0);
        q.offer(start);

        visit[0][0] = 1;

        while(!q.isEmpty()) {
            MazeIndex now = q.poll();
            if(now.i == N - 1 && now.j == M - 1) {
                return visit[now.i][now.j];
            }

            for(int index = 0; index < 4; index++) {
                int nextI = now.i + dirI[index];
                int nextJ = now.j + dirJ[index];

                if(nextI < 0 || nextI >= N || nextJ < 0 || nextJ >= M) {
                    continue;
                }
                if(map[nextI][nextJ] == 0 || visit[nextI][nextJ] != 0) {
                    continue;
                }

                visit[nextI][nextJ] = visit[now.i][now.j] + 1;
                q.offer(new MazeIndex(nextI, nextJ));
            }
        }

        return 0;
    }
}

class MazeIndex {
    int i;
    int j;

    MazeIndex(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
