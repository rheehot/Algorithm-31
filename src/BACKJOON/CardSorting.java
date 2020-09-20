package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;

public class CardSorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new PriorityQueue<>();
        for(int i = 0; i < n; i++) {
            q.add(Integer.parseInt(br.readLine()));
        }

        int ans = 0;
        while(q.size() != 1) {
            int front = q.poll();
            int back = q.poll();

            ans += front + back;
            q.add(front + back);
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();
    }
}
