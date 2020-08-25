package BACKJOON;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DFSandBFS {
    public static boolean[][] map;
    public static int N;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();
        int M = scan.nextInt();
        int V = scan.nextInt();

        map = new boolean[N + 1][N + 1];
        for(int i = 0; i < M; i++) {
            int start = scan.nextInt();
            int end = scan.nextInt();

            map[start][end] = true;
            map[end][start] = true;
        }

        dVisit = new boolean[N + 1];
        DFS(V);
        System.out.println();
        BFS(V);
    }

    public static boolean[] dVisit;
    public static void DFS(int start) {
        System.out.print(start + " ");
        dVisit[start] = true;
        for(int i = 1; i <= N; i++) {
            if(i == start || dVisit[i]) {
                continue;
            }
            if(map[start][i]) {
                dVisit[i] = true;
                DFS(i);
            }
        }
    }

    public static void BFS(int start) {
        boolean[] visit = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visit[start] = true;

        while(!q.isEmpty()) {
            int temp = q.poll();
            System.out.print(temp + " ");

            for(int i = 1; i <= N; i++) {
                if(i == temp || visit[i]) {
                    continue;
                }

                if(map[temp][i]) {
                    q.offer(i);
                    visit[i] = true;
                }
            }
        }
    }
}
