package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
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
        int[] hates = new int[M + 1];
        Arrays.fill(hates, -1);

        map = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());

            if(hates[map[i][1]] == -1) {
                hates[map[i][1]] = i;
            }
        }

        visit[P] = true;
        int count = 0;
        while(true) {
            // 싫어하는 사람이 있음
            int index = hates[P];
            if(index != -1) {
                // 방문했다면
                if(visit[map[index][0]]) {
                    answer = -1;
                    break;
                }
                // 방문 안했다면
                int next = map[index][0];
                visit[next] = true;
                P = next;
                count++;
                continue;
            }
            else {
                answer = count;
                break;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }
}
