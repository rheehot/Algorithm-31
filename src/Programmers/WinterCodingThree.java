package Programmers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class WinterCodingThree {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.flush();
        bw.close();
    }

    static boolean[][] visit;
    static int[][] map;
    public static int[] solution(int[][] v) {
        visit = new boolean[v.length][v.length];
        map = new int[v.length][v.length];
        map = v;
        int[] answer = new int[3];

        for(int i = 0; i < v.length; i++) {
            for(int j = 0; j < v.length; j++) {
                if(!visit[i][j]) {
                    answer[v[i][j]]++;
                    v(v[i][j], i, j);
                }
            }
        }

        return answer;
    }
    static int[] dirI = {0, 0, 1, -1};
    static int[] dirJ = {1, -1, 0, 0};
    public static void v(int origin, int i, int j) {
        visit[i][j] = true;
        for(int index = 0; index < 4; index++) {
            int nextI = i + dirI[index];
            int nextJ = j + dirJ[index];

            if(nextI < 0 || nextI >= visit.length || nextJ < 0 || nextJ >= visit.length || visit[nextI][nextJ]) {
                continue;
            }

            if(origin == map[nextI][nextJ]) {
                v(origin, nextI, nextJ);
            }
        }
    }
}
