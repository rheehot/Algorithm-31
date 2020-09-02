package BACKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumHeap {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());

            if(k == 0) {
                if(q.isEmpty()) {
                    sb.append(0 + "\n");
                }
                else {
                    sb.append(q.poll() * -1 + "\n");
                }
            }
            else {
                q.add(k * -1);
            }
        }
        System.out.println(sb.toString());
    }
}
