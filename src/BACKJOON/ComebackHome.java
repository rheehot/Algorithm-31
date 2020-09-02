package BACKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ComebackHome {
    public static int R;
    public static int C;
    public static int K;
    public static int[][] map;
    public static boolean[][][] visit;

    public static int[] dirI = {0, 0, 1, -1};
    public static int[] dirJ = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        visit = new boolean[R][C][K + 1];
        for(int i = 0; i < R; i++) {
            String str = br.readLine();
            for(int j = 0; j < C; j++) {
                if(str.charAt(j) == 'T') {
                    map[i][j] = 1;
                }
            }
        }

        int answer = 0;
        int count = 1;
        visit[R - 1][0][0] = true;
        Queue<ComebackHomeIndex> q = new LinkedList<>();
        q.offer(new ComebackHomeIndex(R - 1, 0));
        while(!q.isEmpty() && count < K) {
            ComebackHomeIndex temp = q.poll();

            for(int index = 0; index < 4; index++) {
                int tempI = temp.i + dirI[index];
                int tempJ = temp.j + dirJ[index];

                if(tempI < 0 || tempI >= R || tempJ < 0 || tempJ >= C || map[tempI][tempJ] == 1) {
                    continue;
                }
                if(count == K - 1 && tempI == R && tempJ == C) {
                    answer++;
                    continue;
                }

                
            }
        }
    }
}
class ComebackHomeIndex {
    int i;
    int j;

    ComebackHomeIndex(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
