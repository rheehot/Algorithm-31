package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Yosepuse {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= N; i++) {
            q.add(i);
        }

        bw.write("<");
        int count = 0;
        while(!q.isEmpty()) {
            int temp = q.poll();
            count++;
            if(count == K) {
                count = 0;
                bw.write(temp+"");

                if(!q.isEmpty()) {
                    bw.write(", ");
                }

                continue;
            }

            q.add(temp);
        }
        bw.write(">");

        bw.flush();
        bw.close();
    }
}
