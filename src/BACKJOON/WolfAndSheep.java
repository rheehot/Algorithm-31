package BACKJOON;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class WolfAndSheep {
    public static char[][] map;
    public static int[] dirI = {0, 0, 1, -1};
    public static int[] dirJ = {1, -1, 0, 0};

    public static int answer = 0;

    public static Queue<WolfIndex> q = new LinkedList<>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int R = scan.nextInt();
        int C = scan.nextInt();
        map = new char[R][C];

        // map 구성
        scan.nextLine();
        for(int i = 0; i < R; i++) {
            String str = scan.nextLine();

            for(int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'W') {
                    q.offer(new WolfIndex(i, j));
                }
            }
        }

        // 늑대가 없음 -> 무조건 됨
        if(q.isEmpty()) {
            System.out.println(1);
            for(int i = 0; i < R; i++) {
                for(int j = 0; j < C; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }
        else {
            int len = q.size();
            // 양이랑 늑대가 인접 -> 무조건 안됨
            for(int i = 0; i < len; i++) {
                WolfIndex temp = q.poll();
                for(int index = 0; index < 4; index++) {
                    int tempI = temp.i + dirI[index];
                    int tempJ = temp.j + dirJ[index];

                    if(tempI < 0 || tempI >= R || tempJ < 0 || tempJ >= C) {
                        continue;
                    }
                    if(map[tempI][tempJ] == 'S') {
                        System.out.println(0);
                        return;
                    }
                    else if(map[tempI][tempJ] == '.') {
                        map[tempI][tempJ] = 'D';
                    }
                }
                q.offer(temp);
            }

            System.out.println(1);
            for(int i = 0; i < R; i++) {
                for(int j = 0; j < C; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }
    }
}

class WolfIndex {
    int i;
    int j;

    WolfIndex(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
