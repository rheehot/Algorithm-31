package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class DOM {
    public static int N;
    public static int M;
    public static int[][] map;
    public static boolean[] visit;
    public static int answer = -1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        visit = new boolean[M + 1];

        map = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
        }

        solution(P, 0);
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

    public static void solution(int channel, int count) {
        for(int i = 0; i < N; i++) {
            if(map[i][1] == channel && !visit[map[i][0]]) {
                visit[map[i][0]] = true;
                solution(map[i][0], count + 1);
                return;
            }
            if(map[i][1] == channel && visit[map[i][0]]) {
                return;
            }
        }
        answer = count;
        return;
    }
}
