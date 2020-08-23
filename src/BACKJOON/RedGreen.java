package BACKJOON;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RedGreen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[][] map = new int[n][n];
        scan.nextLine();

        for(int i = 0; i < n; i++) {
            String temp = scan.nextLine();
            for(int j = 0; j < n; j++) {
                if(temp.charAt(j) == 'R') {
                    map[i][j] = 1;
                }
                else if(temp.charAt(j) == 'G') {
                    map[i][j] = 2;
                }
                else {
                    map[i][j] = 3;
                }
            }
        }

        System.out.print(solution(false, map) + " ");
        System.out.println(solution(true, map));

    }

    public static int[] dirI = {0, 0, 1, -1};
    public static int[] dirJ = {1, -1, 0, 0};

    public static int solution(boolean RG, int[][] map) {
        int len = map.length;
        boolean[][] visit = new boolean[len][len];

        int areas = 0;
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                if(visit[i][j]) {
                    continue;
                }

                areas++;

                int areaNumber = map[i][j];
                Queue<RedGreenIndex> q = new LinkedList<>();
                q.offer(new RedGreenIndex(i, j));

                while(!q.isEmpty()) {
                    RedGreenIndex temp = q.poll();

                    for(int index = 0; index < 4; index++) {
                        int tempI = temp.i + dirI[index];
                        int tempJ = temp.j + dirJ[index];

                        if(tempI < 0 || tempI >= len || tempJ < 0 || tempJ >= len || visit[tempI][tempJ]) {
                             continue;
                        }

                        // 적록색약
                        if(RG) {
                            if((areaNumber == 3 || map[tempI][tempJ] == 3) && (areaNumber != map[tempI][tempJ])) {
                                continue;
                            }
                        }
                        else {
                            if(areaNumber != map[tempI][tempJ]) {
                                continue;
                            }
                        }

                        visit[tempI][tempJ] = true;
                        q.offer(new RedGreenIndex(tempI, tempJ));
                    }
                }
            }
        }

        return areas;
    }
}

class RedGreenIndex {
    int i;
    int j;

    RedGreenIndex(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
