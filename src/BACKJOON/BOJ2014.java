package BACKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2014 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        long[] prime = new long[n];
        Queue<Long> q = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            prime[i] = Long.parseLong(st.nextToken());
            q.offer(prime[i]);
        }

        long head = 0;
        for(int i = 0; i < target; i++) {
            head = q.poll();

            for(int j = 0; j < n; j++) {
                long value = head * prime[j];
                q.add(value);
                if(head % prime[j] == 0) {
                    break;
                }
            }
        }

        System.out.println(head);
    }
}
