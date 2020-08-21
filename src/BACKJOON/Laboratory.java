package BACKJOON;

import java.util.*;

public class Laboratory {
    public static int answer = 0;

    public static int[] dirI = {0, 1, 0, -1};
    public static int[] dirJ = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();

        int[][] map = new int[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                map[i][j] = scan.nextInt();
            }
        }

        solution(map, 0, N, M);

        System.out.println(answer);
    }

    public static void solution(int[][] map, int count, int N, int M) {
        if(count >= 3) {
            judge(map, N, M);
            return;
        }

        // 0: 빈칸, 1: 벽, 2: 바이러스
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    solution(deepCopy(map, N, M), count + 1, N, M);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static int[][] deepCopy(int[][] original, int N, int M) {
        if (original == null) {
            return null;
        }

        int[][] result = new int[N][M];
        for(int i = 0; i < original.length; i++) {
            System.arraycopy(original[i], 0, result[i], 0, original[i].length);
        }

        return result;
    }

    public static void judge(int[][] map, int N, int M) {

        Queue<Index> q = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                // 바이러스
                if(map[i][j] == 2) {
                    q.add(new Index(i, j));
                }
            }
        }

        while(!q.isEmpty()) {
            Index temp = q.remove();

            for(int i = 0; i < 4; i++) {
                int tempI = temp.i + dirI[i];
                int tempJ = temp.j + dirJ[i];

                if(tempI < 0 || tempI >= N) {
                    continue;
                }
                if(tempJ < 0 || tempJ >= M) {
                    continue;
                }
                if(map[tempI][tempJ] == 2 || map[tempI][tempJ] == 1) {
                    continue;
                }

                map[tempI][tempJ] = 2;
                q.add(new Index(tempI, tempJ));
            }
        }

        int a = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 0) {
                    a++;
                }
            }
        }
        if(answer < a) {
            answer = a;
        }
    }
}
class Index {
    int i;
    int j;

    Index(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
