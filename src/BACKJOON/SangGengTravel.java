package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SangGengTravel {

    static int N, M, answer;
    static int[][] air;
    static boolean[] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 국가 수
            N = Integer.parseInt(st.nextToken());
            // 비행기 종류
            M = Integer.parseInt(st.nextToken());
            answer = 0;

            air = new int[N + 1][N + 1];
            visit = new boolean[N + 1];
            for(int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                air[a][b] = 1;
                air[b][a] = 1;
            }
            solution();
            bw.write((answer - 1) +"\n");
        }

        bw.flush();
        bw.close();
    }

    public static void solution() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visit[1] = true;

        while(!q.isEmpty()) {
            answer++;

            int temp = q.poll();
            for(int i = 1; i <= N; i++) {
                if(!visit[i] && air[temp][i] == 1) {
                    visit[i] = true;
                    q.add(i);
                }
            }
        }
    }
}