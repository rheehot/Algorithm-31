package BACKJOON;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FindRoute {
    public static int[][] map;
    public static int[][] answer;
    public static int N;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        map = new int[N][N];
        answer = new int[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                map[i][j] = scan.nextInt();
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                solution(i, j);
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void solution(int start, int target) {
        boolean[] visit = new boolean[N];
        int[] count = new int[N];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()) {
            int temp = q.poll();

            if(temp == target) {
                if(count[temp] > 0) {
                    answer[start][target] = 1;
                    return;
                }
            }

            for(int i = 0; i < N; i++) {
                if(visit[i]) {
                    continue;
                }
                if(map[temp][i] == 1) {
                    q.offer(i);
                    visit[i] = true;
                    count[i] = count[temp] + 1;
                }
            }
        }
    }
}
