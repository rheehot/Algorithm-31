package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class RollingCube {
    static int N, M;
    static int[][] map;
    static int curI, curJ;
    static int front, bottom, right;

    static int[] dirI = {0, 0, 0, -1, 1};
    static int[] dirJ = {0, 1, -1, 0, 0};

    static int[] cube = new int[7];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        curI = Integer.parseInt(st.nextToken());
        curJ = Integer.parseInt(st.nextToken());

        front = 5;
        bottom = 1;
        right = 3;

        int K = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int k = 0; k < K; k++) {
            int dir = Integer.parseInt(st.nextToken());

            int r = rolling(dir);
            if(r < 0) {
                continue;
            }
            else {
                bw.write(r + "\n");
            }
        }

        bw.flush();
        bw.close();
    }

    static int rolling(int dir) {
        int tempI = curI + dirI[dir];
        int tempJ = curJ + dirJ[dir];

        // 바깥으로 이동
        if(tempI < 0 || tempI >= N || tempJ < 0 || tempJ >= M) {
            return -1;
        }

        int temp = 0;
        switch(dir) {
            case 1:
                temp = bottom;
                bottom = right;
                right = 7 - temp;
                break;
            case 2:
                temp = right;
                right = bottom;
                bottom = 7 - temp;
                break;
            case 3:
                temp = front;
                front = bottom;
                bottom = 7 - temp;
                break;
            case 4:
                temp = bottom;
                bottom = front;
                front = 7 - temp;
                break;
        }

        curI = tempI;
        curJ = tempJ;
        if(map[tempI][tempJ] == 0) {
            map[tempI][tempJ] = cube[bottom];
        }
        else {
            cube[bottom] = map[tempI][tempJ];
            map[tempI][tempJ] = 0;
        }

        return cube[7 - bottom];
    }

}
