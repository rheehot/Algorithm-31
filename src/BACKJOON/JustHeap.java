package BACKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class JustHeap {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> plusQ = new PriorityQueue<>();
        Queue<Integer> minusQ = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if(x == 0) {
                if(plusQ.isEmpty() && minusQ.isEmpty()) {
                    sb.append(0 + "\n");
                }
                else {
                    if(plusQ.isEmpty()) {
                        sb.append(minusQ.poll() * -1 + "\n");
                    }
                    else if(minusQ.isEmpty()) {
                        sb.append(plusQ.poll() + "\n");
                    }
                    // minus 출력
                    else if(plusQ.peek() == Math.abs(minusQ.peek()) || plusQ.peek() > Math.abs(minusQ.peek())) {
                        sb.append(minusQ.poll() * -1 + "\n");
                    }
                    else {
                        sb.append(plusQ.poll() + "\n");
                    }
                }
            }
            else if(x < 0) {
                minusQ.offer(x * -1);
            }
            else if(x > 0){
                plusQ.offer(x);
            }
        }
        System.out.print(sb);
    }
}
