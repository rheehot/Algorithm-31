package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ1655 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<Integer> max = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        Queue<Integer> min = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            if(min.size() == max.size()) {
                min.offer(Integer.parseInt(br.readLine()));
            }
            else {
                max.offer(Integer.parseInt(br.readLine()));
            }
            if(i == 0) {
                bw.write(min.peek() + "\n");
                continue;
            }

            if(!min.isEmpty() && !max.isEmpty()) {
                if(min.peek() < max.peek()) {
                    int temp = min.poll();
                    min.offer(max.poll());
                    max.offer(temp);
                }
            }

            if(min.size() == max.size()) {
                bw.write(Math.min(min.peek(), max.peek()) + "\n");
            }
            else if(min.size() < max.size()) {
                bw.write(max.peek() + "\n");
            }
            else {
                bw.write(min.peek() + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
