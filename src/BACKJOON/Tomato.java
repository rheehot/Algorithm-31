package BACKJOON;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class TomatoIndex {
    int i;
    int j;

    TomatoIndex(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

public class Tomato {

    public static int N;
    public static int M;
    public static int[][] map;

    // 안 익은 토마토
    public static int notTomato = 0;
    public static Queue<TomatoIndex> q = new LinkedList<>();

    public static int answer = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        M = scan.nextInt();
        N = scan.nextInt();

        map = new int[N][M];

        // 모든 토마토가 익어있음
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                map[i][j] = scan.nextInt();

                if(map[i][j] == 0) {
                    notTomato++;
                }
                if(map[i][j] == 1) {
                    q.offer(new TomatoIndex(i, j));
                }
            }
        }
        if(notTomato == 0) {
            System.out.println(0);
        }
        else {
            solution();
            System.out.println(answer);
        }
    }

    public static int[] dirI = {0, 0, 1, -1};
    public static int[] dirJ = {1, -1, 0, 0};

    public static void solution() {
        // 현재 안 익은 토마토 수
        int prevNotTomato = notTomato;

        int len = q.size();
        for(int size = 0; size < len; size++) {
            TomatoIndex tomato = q.poll();

            for(int index = 0; index < 4; index++) {
                int tempI = tomato.i + dirI[index];
                int tempJ = tomato.j + dirJ[index];

                if(tempI < 0 || tempI >= N || tempJ < 0 || tempJ >= M) {
                    continue;
                }
                if(map[tempI][tempJ] == 0) {
                    map[tempI][tempJ] = 1;
                    notTomato--;
                    q.offer(new TomatoIndex(tempI, tempJ));
                }
            }
        }

        // 익은 토마토 없음
        if(prevNotTomato == notTomato) {
            if(notTomato != 0) {
                answer = -1;
                return;
            }
            if(q.isEmpty()) {
                return;
            }else{
                answer = -1;
                return;
            }
        }else {
            answer++;
            solution();
        }
    }
}
