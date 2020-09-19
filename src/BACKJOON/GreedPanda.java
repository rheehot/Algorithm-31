package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class GreedPanda {
    static int N;
    static int[][] map;
    static int[][] panda;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        panda = new int[N][N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 1;
        int[][] visit = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                answer = Math.max(answer, solution(visit, i, j));
            }
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
    }

    static int[] dirI = {0, 0, 1, -1};
    static int[] dirJ = {1, -1, 0, 0};

    static int solution(int[][] visit, int curI, int curJ) {
        if(visit[curI][curJ] != 0) {
            return visit[curI][curJ];
        }

        visit[curI][curJ] = 1;

        for(int index = 0; index < 4; index++) {
            int nextI = curI + dirI[index];
            int nextJ = curJ + dirJ[index];

            if(nextI >= N || nextI < 0 || nextJ >= N || nextJ < 0) {
                continue;
            }

            if(map[curI][curJ] < map[nextI][nextJ]) {
                visit[curI][curJ] = Math.max(visit[curI][curJ], solution(visit, nextI, nextJ) + 1);
            }
        }

        return visit[curI][curJ];
    }
}

class PandaIndex {
    int i;
    int j;

    PandaIndex(int i, int j) {
        this.i = i;
        this.j = j;
    }
}