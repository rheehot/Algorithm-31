package BACKJOON;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class HorseIndex {
    int i;
    int j;
    int horse;

    HorseIndex(int i, int j, int horse) {
        this.i = i;
        this.j = j;
        this.horse = horse;
    }
}

public class HorseMonkey {
    public static int K;
    public static int[][] map;
    public static boolean[][][] visit;
    public static int W;
    public static int H;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        K = scan.nextInt();
        W = scan.nextInt();
        H = scan.nextInt();

        map = new int[H][W];
        visit = new boolean[H][W][K + 1];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                map[i][j] = scan.nextInt();
            }
        }

        Queue<HorseIndex> q = new LinkedList<>();
        q.offer(new HorseIndex(0, 0, 0));
        visit[0][0][0] = true;

        int count = 0;
        while(!q.isEmpty()) {
            int len = q.size();
            for(int index = 0; index < len; index++) {
                HorseIndex temp = q.poll();

                if(temp.i == H - 1 && temp.j == W - 1) {
                    System.out.println(count);
                    return;
                }

                for(int i = 0; i < horseI.length; i++) {
                    if(i < 8 && temp.horse >= K) {
                        continue;
                    }
                    int tempI = temp.i + horseI[i];
                    int tempJ = temp.j + horseJ[i];

                    if(tempI < 0 || tempI >= H || tempJ < 0 || tempJ >= W || map[tempI][tempJ] == 1) {
                        continue;
                    }
                    if((i < 8 && visit[tempI][tempJ][temp.horse + 1]) || i >= 8 && visit[tempI][tempJ][temp.horse]) {
                        continue;
                    }

                    if(i < 8) {
                        visit[tempI][tempJ][temp.horse + 1] = true;
                        q.offer(new HorseIndex(tempI, tempJ, temp.horse + 1));
                    }
                    else {
                        visit[tempI][tempJ][temp.horse] = true;
                        q.offer(new HorseIndex(tempI, tempJ, temp.horse));
                    }
                }
            }
            count++;
        }

        System.out.println(-1);
    }

    public static int[] horseI = {-1, -2, -2, -1, 1, 2, 2, 1, 0, 0, 1, -1};
    public static int[] horseJ = {-2, -1, 1, 2, 2, 1, -1, -2, 1, -1, 0, 0};

}
