package BACKJOON;

import java.util.HashMap;
import java.util.Scanner;

public class Fishing {

    static int[] dirI = {-1, 0, 1, 0};
    static int[] dirJ = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int R = scan.nextInt();
        int C = scan.nextInt();
        int[][] isShark = new int[R + 1][C + 1];
        HashMap<Integer, Shark> sharkMap = new HashMap<>();
        int M = scan.nextInt();

        int sharkIndex = 1;
        for(int index = 0; index < M; index++) {
            int r = scan.nextInt();
            int c = scan.nextInt();
            int s = scan.nextInt();
            int d = scan.nextInt();
            int z = scan.nextInt();

            if (d == 1) {
                d = 0;
            }
            else if(d == 3) {
                d = 1;
            }
            else if(d == 4) {
                d = 3;
            }

            // 상어 위치 표시
            isShark[r][c] = sharkIndex;
            // 상어 표시
            sharkMap.put(sharkIndex, new Shark(d, z, s));
            sharkIndex++;
        }

        int result = 0;

        int king = 0;
        while(king < C) {
            king++;
            for(int i = 1; i <= R; i++) {
                // 상어가 있다면
                if (isShark[i][king] != 0) {
                    Shark dead = sharkMap.remove(isShark[i][king]);
                    result += dead.size;
                    isShark[i][king] = 0;
                    break;
                }
            }

            int[][] nextMap = new int[R + 1][C + 1];
            for(int i = 1; i < isShark.length; i++) {
                for(int j = 1; j < isShark[0].length; j++) {
                    // 상어가 있는 곳
                    if (isShark[i][j] != 0) {

                        Shark temp = sharkMap.get(isShark[i][j]);
                        int tempI = i;
                        int tempJ = j;
                        for(int s = 1; s <= temp.speed; s++) {

                            if (temp.dir == 0 && tempI <= 1) {
                                temp.dir = (temp.dir + 2) % 4;
                            }
                            else if (temp.dir == 2 && tempI >= R) {
                                temp.dir = (temp.dir + 2) % 4;
                            }
                            else if (temp.dir == 1 && tempJ >= C) {
                                temp.dir = (temp.dir + 2) % 4;
                            }
                            else if (temp.dir == 3 && tempJ <= 1) {
                                temp.dir = (temp.dir + 2) % 4;
                            }

                            tempI = tempI + dirI[temp.dir];
                            tempJ = tempJ + dirJ[temp.dir];
                        }

                        // 이동한 곳에 상어가 있음
                        if (nextMap[tempI][tempJ] != 0) {
                            Shark prev = sharkMap.get(nextMap[tempI][tempJ]);
                            // 새로 들어갈 애가 이전 상어 잡아 먹음
                            if (prev.size < temp.size) {
                                nextMap[tempI][tempJ] = isShark[i][j];
                            }
                        }
                        else {
                            nextMap[tempI][tempJ] = isShark[i][j];
                        }
                    }
                }
            }
            for(int i = 1; i <= R; i++) {
                for(int j = 1; j <= C; j++) {
                    isShark[i][j] = nextMap[i][j];
                }
            }
//            isShark = nextMap;
        }

        System.out.println(result);
    }

}

class Shark {
    int dir;
    int size;
    int speed;

    Shark(int dir, int size, int speed) {
        this.dir = dir;
        this.size = size;
        this.speed = speed;
    }
}