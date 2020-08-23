package BACKJOON;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TomatoTwo {

    public static int notTomato = 0;
    public static Queue<TomatoTwoIndex> q = new LinkedList<>();

    public static int answer = 0;

    public static int[][][] map;

    public static int M;
    public static int N;
    public static int H;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        M = scan.nextInt();
        N = scan.nextInt();
        H = scan.nextInt();

        map = new int[M][N][H];

        for(int h = 0; h < H; h++) {
            for(int j = 0; j < N; j++) {
                for(int i = 0; i < M; i++) {
                    map[i][j][h] = scan.nextInt();

                    if(map[i][j][h] == 0) {
                        notTomato++;
                    }
                    if(map[i][j][h] == 1) {
                        q.offer(new TomatoTwoIndex(i, j, h));
                    }
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

    public static int[] dirI = {0, 0, 1, -1, 0, 0};
    public static int[] dirJ = {1, -1, 0, 0, 0, 0};
    public static int[] dirH = {0, 0, 0, 0, 1, -1};

    public static void solution() {
        int prevNotTomato = notTomato;

        int len = q.size();
        for(int size = 0; size < len; size++) {
            TomatoTwoIndex tomato = q.poll();

            for(int index = 0; index < 6; index++) {
                int tempI = tomato.i + dirI[index];
                int tempJ = tomato.j + dirJ[index];
                int tempH = tomato.h + dirH[index];

                if(tempI < 0 || tempI >= M || tempJ < 0 || tempJ >= N || tempH < 0 || tempH >= H) {
                    continue;
                }
                if(map[tempI][tempJ][tempH] == 0) {
                    map[tempI][tempJ][tempH] = 1;
                    notTomato--;
                    q.offer(new TomatoTwoIndex(tempI, tempJ, tempH));
                }
            }
        }

        if(prevNotTomato == notTomato) {
            if(notTomato != 0) {
                answer = -1;
                return;
            }
            if(q.isEmpty()) {
                return;
            } else {
              answer = -1;
              return;
            }
        } else {
            answer++;
            solution();
        }
    }
}

class TomatoTwoIndex {
    int i;
    int j;
    int h;

    TomatoTwoIndex(int i, int j, int h) {
        this.i = i;
        this.j = j;
        this.h = h;
    }
}