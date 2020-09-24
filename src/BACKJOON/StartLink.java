package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class StartLink {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        boolean[] visit = new boolean[F + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(S);
        visit[S] = true;
        int count = 0;

        boolean isTarget = false;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int temp = q.poll();
                if(temp == G) {
                    isTarget = true;
                    break;
                }

                if(temp - D > 0 && !visit[temp - D]) {
                    visit[temp - D] = true;
                    q.offer(temp - D);
                }
                if(temp + U <= F && !visit[temp + U]) {
                    visit[temp + U] = true;
                    q.offer(temp + U);
                }
            }
            if(isTarget) {
                break;
            }
            count++;
        }

        if(isTarget) {
            bw.write(count + "");
        }
        else {
            bw.write("use the stairs");
        }

        bw.flush();
        bw.close();
    }
}
