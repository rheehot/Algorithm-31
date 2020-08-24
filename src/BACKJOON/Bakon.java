package BACKJOON;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bakon {
    public static boolean[][] map;
    public static int[] answer;
    public static int N;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();
        int M = scan.nextInt();

        map = new boolean[N + 1][N + 1];
        answer = new int[N + 1];

        for(int m = 0; m < M; m++) {
            int f1 = scan.nextInt();
            int f2 = scan.nextInt();

            map[f1][f2] = true;
            map[f2][f1] = true;
        }

        solution();

        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for(int i = 1; i <= N ; i++) {

            if(min > answer[i]) {
                min = answer[i];
                minIndex = i;
            }
        }

        System.out.println(minIndex);
    }

    public static void solution() {
        for(int i = 1; i <= N; i++) {

            int k = 0;
            for(int j = 1; j <= N; j++) {
                if(i == j) {
                    continue;
                }

                k += kevin(i, j);
            }
            answer[i] = k;
        }
    }

    public static int kevin(int start, int target) {
        int[] visit = new int[N + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while(!q.isEmpty()) {
            int temp = q.poll();

            if(temp == target) {
                return visit[target];
            }

            for(int j = 1; j <= N; j++) {
                if(map[temp][j] && visit[j] == 0) {
                    visit[j] = visit[temp] + 1;
                    q.offer(j);
                }
            }
        }

        return visit[target];
    }
}
