package BACKJOON;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CalFamilyNumber {
    public static int[] child;

    public static int people;
    public static int start;
    public static int target;

    public static int[] visit;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        people = scan.nextInt();

        child = new int[people + 1];
        visit = new int[people + 1];

        start = scan.nextInt();
        target = scan.nextInt();

        int n = scan.nextInt();
        for(int i = 0; i < n; i++) {
            int p = scan.nextInt();
            int c = scan.nextInt();

            child[c] = p;
        }

        System.out.println(solution());
    }

    public static int solution() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visit[start] = -1;

        while(!q.isEmpty()) {
            int prev = q.poll();

            if(prev == target) {
                return visit[target] + 1;
            }

            if(child[prev] != 0 && visit[child[prev]] == 0) {
                visit[child[prev]] = visit[prev] + 1;
                q.offer(child[prev]);
            }

            for(int i = 1; i <= people; i++) {
                if(child[i] == prev && visit[i] == 0) {
                    visit[i] = visit[prev] + 1;
                    q.offer(i);
                }
            }
        }

        return -1;
    }
}