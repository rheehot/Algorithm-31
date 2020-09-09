package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class DongBangProject {
    static int N, M;
    static int[] rooms;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        rooms = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            rooms[i] = i;
        }

        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            for(int j = start + 1; j <= end; j++) {
                union(start, j);
            }
        }

        boolean[] visit = new boolean[N + 1];
        int answer = 0;
        for(int i = 1; i <= N; i++) {
            int p = find(rooms[i]);
            if(!visit[p]) {
                answer++;
                visit[p] = true;
            }
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
    }

    public static int find(int x) {
        if(x == rooms[x]) {
            return x;
        }
        else {
            return rooms[x] = find(rooms[x]);
        }
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x != y) {
            rooms[y] = x;
        }
    }
}
