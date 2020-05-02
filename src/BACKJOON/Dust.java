package BACKJOON;

import java.util.Scanner;

public class Dust {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int R = scan.nextInt();
        int C = scan.nextInt();
        int T = scan.nextInt();

        int[][] dustMap = new int[R][C];
        int air = -1;
        for(int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                dustMap[i][j] = scan.nextInt();
                if (dustMap[i][j] == -1 && air < 0) {
                    air = i;
                }
            }
        }

        for(int t = 1; t <= T; t++) {
            dustMap = spreadDust(dustMap);
            dustMap = wind(dustMap, air);
        }

        int result = 0;
        for(int i = 0; i < dustMap.length; i++) {
            for(int j = 0; j < dustMap[0].length; j++) {
                if (dustMap[i][j] > 0) {
                    result += dustMap[i][j];
                }
            }
        }

        System.out.println(result);
    }

    public static int[][] spreadDust(int[][] dustMap) {
        int[][] tempDust = new int[dustMap.length][dustMap[0].length];
        for(int i = 0; i < dustMap.length; i++) {
            for(int j = 0; j < dustMap[0].length; j++) {
                tempDust[i][j] = dustMap[i][j];
            }
        }

        int[] dirI = {-1, 0, 1, 0};
        int[] dirJ = {0, 1, 0, -1};

        for(int i = 0; i < dustMap.length; i++) {
            for(int j = 0; j < dustMap[0].length; j++) {
                // 미세먼지가 있다면
                if(tempDust[i][j] > 0) {
                    int count = 0;
                    for(int index = 0; index < dirI.length; index++) {
                        if (i + dirI[index] < 0 || i + dirI[index] >= dustMap.length) {
                            continue;
                        }
                        if(j + dirJ[index] < 0 || j + dirJ[index] >= dustMap[0].length) {
                            continue;
                        }
                        if(dustMap[i + dirI[index]][j + dirJ[index]] == -1) {
                            continue;
                        }

                        count++;
                        dustMap[i + dirI[index]][j + dirJ[index]] += tempDust[i][j] / 5;
                    }

                    dustMap[i][j] -= ((tempDust[i][j] / 5) * count);
                }
            }
        }

        return dustMap;
    }

    public static int[][] wind(int[][] dustMap, int air) {

        int[][] tempDust = new int[dustMap.length][dustMap[0].length];
        for(int i = 0; i < dustMap.length; i++) {
            for(int j = 0; j < dustMap[0].length; j++) {
                tempDust[i][j] = dustMap[i][j];
            }
        }

        // 공기청정기 위쪽 바람
        int[] topI = {0, -1, 0, 1};
        int[] topJ = {1, 0, -1, 0};
        int index = 0;
        int tempI = air;
        int tempJ = 0;
        while(true) {
            // 4방향의 바람을 다 돌음
            if(index > 4) {
                break;
            }
            if(tempI + topI[index] < 0 || tempI + topI[index] > air) {
                index++;
                continue;
            }
            if(tempJ + topJ[index] < 0 || tempJ + topJ[index] >= dustMap[0].length) {
                index++;
                continue;
            }
            // 시작점이 공기청정기
            if(dustMap[tempI][tempJ] == -1) {
                dustMap[tempI + topI[index]][tempJ + topJ[index]] = 0;
                tempI += topI[index];
                tempJ += topJ[index];
                continue;
            }
            // 공기청정기로 들어가는 것
            if(dustMap[tempI + topI[index]][tempJ + topJ[index]] == -1) {
                break;
            }

            dustMap[tempI + topI[index]][tempJ + topJ[index]] = tempDust[tempI][tempJ];
            tempI += topI[index];
            tempJ += topJ[index];
        }

        // 공기청정기 아래쪽 바람
        int[] bottomI = {0, 1, 0, -1};
        int[] bottomJ = {1, 0, -1, 0};
        index = 0;
        tempI = air+1;
        tempJ = 0;
        while(true) {
            // 4방향의 바람을 다 돌음
            if(index > 4) {
                break;
            }
            if(tempI + bottomI[index] >= dustMap.length || tempI + bottomI[index] < air + 1) {
                index++;
                continue;
            }
            if(tempJ + bottomJ[index] < 0 || tempJ + bottomJ[index] >= dustMap[0].length) {
                index++;
                continue;
            }
            if(dustMap[tempI][tempJ] == -1) {
                dustMap[tempI + bottomI[index]][tempJ + bottomJ[index]] = 0;
                tempI += bottomI[index];
                tempJ += bottomJ[index];
                continue;
            }
            if(dustMap[tempI + bottomI[index]][tempJ + bottomJ[index]] == -1) {
                break;
            }

            dustMap[tempI + bottomI[index]][tempJ + bottomJ[index]] = tempDust[tempI][tempJ];
            tempI += bottomI[index];
            tempJ += bottomJ[index];
        }

        return dustMap;
    }

}
