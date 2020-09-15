package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

// 15:44 - 15:54
public class Passing {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Queue<String> q = new LinkedList<>();
        // 차가 들어감
        for(int i = 0; i < N; i++) {
            q.offer(br.readLine());
        }

        int answer = 0;
        for(int i = 0; i < N; i++) {
            String num = br.readLine();
            // 추월
            if(!q.peek().equals(num)) {
                answer++;

                int len = q.size();
                for(int s = 0; s < len; s++) {
                    String temp = q.poll();
                    if(temp.equals(num)) {
                        continue;
                    }

                    q.offer(temp);
                }

                continue;
            }
            q.poll();
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
    }
}
