package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16397 {
    static int n, t, g;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());

        int answer = solution();
        if(answer == -1) {
            bw.write("ANG\n");
        }
        else {
            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static int solution() {
        boolean[] visit = new boolean[100000];
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        int count = 0;

        while(!q.isEmpty()) {
            if(count > t) {
                return -1;
            }

            int size = q.size();
            for(int s = 0; s < size; s++) {
                int temp = q.poll();
                if(temp == g) {
                    return count;
                }

                // A 누름
                if(temp + 1 <= 99999 && !visit[temp + 1]) {
                    q.offer(temp + 1);
                    visit[temp + 1] = true;
                }

                // B 누름
                if(temp == 0) {
                    continue;
                }
                int b = B(temp);
                if(b != -1 && !visit[b]) {
                    q.offer(b);
                    visit[b] = true;
                }
            }
            count++;
        }

        return -1;
    }

    public static int B(int origin) {
        if(origin * 2 > 99999) {
            return -1;
        }

        origin *= 2;
        if(origin < 10) {
            return origin - 1;
        }
        if(origin == 10) {
            return 0;
        }

        String temp = origin + "";
        if(temp.charAt(0) == '1') {
            return Integer.parseInt(temp.substring(1));
        }

        int t = temp.charAt(0) - '0';
        t--;
        temp = t + temp.substring(1);
        return Integer.parseInt(temp);
    }
}
