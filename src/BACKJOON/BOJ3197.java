package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ3197 {
    static int R, C;
    static int[][] map;
    static boolean meet = false;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[C][R];

        int swan = -1;
        for(int row = 0; row < C; row++) {
            String str = br.readLine();
            for(int col = 0; col < R; col++) {
                if(str.charAt(col) == 'X') {
                    map[row][col] = 1;
                }
                if(str.charAt(col) == 'L') {
                    map[row][col] = swan;
                    swan--;
                }
            }
        }
        int days = 0;
        while(!meet) {

            for(int i = 0; i < C; i++) {
                for(int j = 0; j < R; j++) {
                    if(map[i][j] == -1) {
                        move(i, j);
                        if(meet) {
                            bw.write(days + "");
                            break;
                        }
                    }
                }
                if(meet) {
                    break;
                }
            }
            if(meet) {
                break;
            }

            melt();

            days++;
        }

        bw.flush();
        bw.close();
    }

    static int[] dirI = {0, 0, 1, -1};
    static int[] dirJ = {1, -1, 0, 0};

    // 빙판 녹이기
    public static void melt() {
        boolean[][] visit = new boolean[C][R];
        for(int i = 0; i < C; i++) {
            for(int j = 0; j < R; j++) {
                if(map[i][j] != 1) {
                    continue;
                }

                // 빙판
                for(int index = 0; index < 4; index++) {
                    int nextI = i + dirI[index];
                    int nextJ = j + dirJ[index];
                    if(nextI < 0 || nextI >= C || nextJ < 0 || nextJ >= R) {
                        continue;
                    }

                    // 녹는 빙하
                    if(map[nextI][nextJ] == 0) {
                        visit[i][j] = true;
                        break;
                    }
                }
            }
        }

        for(int i = 0; i < C; i++) {
            for(int j = 0; j < R; j++) {
                if(visit[i][j]) {
                    map[i][j] = 0;
                }
            }
        }
    }

    // 백조 움직이기
    public static void move(int i, int j) {
        if(meet) {
            return;
        }
        for(int index = 0; index < 4; index++) {
            int nextI = i + dirI[index];
            int nextJ = j + dirJ[index];

            if(nextI < 0 || nextI >= C || nextJ < 0 || nextJ >= R || map[nextI][nextJ] == 1 || map[nextI][nextJ] == -1) {
                continue;
            }
            if(map[nextI][nextJ] == -2) {
                meet = true;
                return;
            }
            if(map[nextI][nextJ] == 0) {
                map[nextI][nextJ] = -1;
                move(nextI, nextJ);
            }
        }
    }

}

class SwanNode {
    int i;
    int j;

    SwanNode(int i, int j) {
        this.i = i;
        this.j = j;
    }
}