package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BabyShark {
    static int N;
    static int[][] map;
    // 사이즈별 물고기 갯수
    static int[] fishCount = new int[7];
    static SharkNode shark;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                // 상어
                if(num == 9) {
                    shark = new SharkNode(i, j);
                    continue;
                }

                // 빈 곳
                if(num == 0) {
                    continue;
                }

                map[i][j] = num;
                fishCount[num]++;
            }
        }

        int answer = 0;

        while(checkEat()) {
            int second = moveShark();
            if(second < 0) {
                break;
            }
            answer += second;
        }
        bw.write(answer + "");
        bw.flush();
        bw.close();
    }

    // 먹을 물고기 있는지
    static boolean checkEat() {
        int limit = shark.s;
        if(limit > 6) {
            limit = 7;
        }
        for(int i = 1; i < limit; i++) {
            if(fishCount[i] != 0) {
                return true;
            }
        }

        return false;
    }

    static int[] dirI = {0, 0, 1, -1};
    static int[] dirJ = {1, -1, 0, 0};

    // 상어 이동
    static int moveShark() {
        Queue<SharkNode> q = new LinkedList<>();
        q.offer(shark);
        boolean[][] visit = new boolean[N][N];
        visit[shark.i][shark.j] = true;

        int second = 0;

        int fishI = -1;
        int fishJ = -1;
        SharkNode curShark = shark;

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                SharkNode temp = q.poll();

                // 상어보다 작은 size 물고기
                if(map[temp.i][temp.j] != 0 && map[temp.i][temp.j] < temp.s) {
                    if(fishI == -1) {
                        fishI = temp.i;
                        fishJ = temp.j;
                        curShark = temp;
                    }

                    // j 비교
                    if(fishI == temp.i) {
                        if(fishJ > temp.j) {
                            fishI = temp.i;
                            fishJ = temp.j;
                            curShark = temp;
                        }
                    }
                    else if(fishI > temp.i){
                        fishI = temp.i;
                        fishJ = temp.j;
                        curShark = temp;
                    }
                }

                for(int index = 0; index < 4; index++) {
                    int nextI = temp.i + dirI[index];
                    int nextJ = temp.j + dirJ[index];

                    if(nextI < 0 || nextI >= N || nextJ < 0 || nextJ >= N || visit[nextI][nextJ] || map[nextI][nextJ] > temp.s) {
                        continue;
                    }

                    visit[nextI][nextJ] = true;
                    SharkNode nextShark = new SharkNode(nextI, nextJ);
                    nextShark.s = temp.s;
                    nextShark.eatFish = temp.eatFish;
                    q.offer(nextShark);
                }
            }
            // 상어가 물고기 먹음
            if(fishI != -1 && fishJ != -1) {
                int fishSize = map[fishI][fishJ];
                fishCount[fishSize]--;
                map[fishI][fishJ] = 0;
                curShark.eatFish++;
                if(curShark.eatFish == curShark.s) {
                    curShark.s++;
                    curShark.eatFish = 0;
                }

                shark = curShark;

                return second;
            }
            second++;
        }

        return -1;
    }
}

class SharkNode {
    int i;
    int j;
    // 상어 크기
    int s;
    // 먹은 물고기 갯수
    int eatFish;

    SharkNode(int i, int j) {
        this.i = i;
        this.j = j;

        s = 2;
        eatFish = 0;
    }
}