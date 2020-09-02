package BACKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumHeap {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new PriorityQueue<>();

        for(int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if(x == 0) {
                if(q.isEmpty()) {
                    sb.append(0 + "\n");
                }
                else {
                    sb.append(q.poll() + "\n");
                }
            }
            else {
                q.add(x);
            }
        }

        System.out.println(sb);
    }
}
