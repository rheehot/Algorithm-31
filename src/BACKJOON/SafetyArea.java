package BACKJOON;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SafetyArea {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[][] map = new int[n][n];
        int max = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                map[i][j] = scan.nextInt();
                if(max < map[i][j]) {
                    max = map[i][j];
                }
            }
        }

        for(int i = 0; i < max; i++) {
            solution(map, i);
        }

        System.out.print(answer);
    }

    static int[] dirI = {0, 0, 1, -1};
    static int[] dirJ = {1, - 1, 0, 0};

    static int answer = 0;

    public static void solution(int[][] map, int rain) {
        int len = map.length;
        boolean[][] visit = new boolean[len][len];

        int count = 0;
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                if(!visit[i][j] && map[i][j] > rain) {
                    count++;
                    visit[i][j] = true;

                    Queue<SafetyAreaIndex> q = new LinkedList<>();
                    q.offer(new SafetyAreaIndex(i, j));

                    while(!q.isEmpty()) {
                        SafetyAreaIndex temp = q.poll();

                        for(int index = 0; index < 4; index++) {
                            int tempI = temp.i + dirI[index];
                            int tempJ = temp.j + dirJ[index];

                            if(tempI < 0 || tempI >= len || tempJ < 0 || tempJ >= len) {
                                continue;
                            }
                            if(visit[tempI][tempJ] || map[tempI][tempJ] <= rain) {
                                continue;
                            }

                            visit[tempI][tempJ] = true;
                            q.offer(new SafetyAreaIndex(tempI, tempJ));
                        }
                    }
                }
            }
        }

        if(count > answer) {
            answer = count;
        }
    }
}

class SafetyAreaIndex {
    int i;
    int j;

    SafetyAreaIndex(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
