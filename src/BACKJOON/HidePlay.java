package BACKJOON;

import java.util.*;

public class HidePlay {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int K = scan.nextInt();

        Queue<Integer> q = new LinkedList<>();
        q.add(N);

        if(N >= K) {
            System.out.println(N - K);
        }
        else {
            System.out.println(solution(N, K));
        }
    }

    public static int solution(int N, int K) {
        Queue<Integer> q = new LinkedList<>();
        int[] visit = new int[100001];

        q.offer(N);
        visit[N] = 1;

        while(!q.isEmpty()) {
            int now = q.poll();

            for(int i = 0; i < 3; i++) {
                int next;

                if(i == 0) {
                    next = now - 1;
                }
                else if (i == 1) {
                    next = now + 1;
                }
                else {
                    next = now * 2;
                }

                if(next == K)
                    return visit[now];

                if(0 <= next && next <= 100000) {
                    if(visit[next] == 0) {
                        q.offer(next);
                        visit[next] = visit[now] + 1;
                    }
                }
            }
        }

        return 0;
    }
}
