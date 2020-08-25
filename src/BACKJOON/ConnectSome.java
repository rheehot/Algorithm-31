package BACKJOON;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ConnectSome {

    public static boolean[][] map;
    public static boolean[] visit;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();

        map = new boolean[N + 1][N + 1];
        visit = new boolean[N + 1];
        for(int i = 0; i < M; i++) {
            int start = scan.nextInt();
            int end = scan.nextInt();

            map[start][end] = true;
            map[end][start] = true;
        }

        int count = 0;
        for(int i = 1; i <= N; i++) {
            if(!visit[i]) {
                count++;
                solution(i);
            }
        }
        System.out.println(count);
    }

    public static void solution(int start) {
        Queue<ConnectSomeIndex> q = new LinkedList<>();

        for(int i = 0; i < visit.length; i++) {
            if(!visit[i] && map[start][i]) {
                q.offer(new ConnectSomeIndex(start, i));
            }
        }
        while(!q.isEmpty()) {
            ConnectSomeIndex temp = q.poll();

            for(int i = 0; i < visit.length; i++) {
                if(temp.end == i || visit[i]) {
                    continue;
                }
                if(map[temp.end][i]) {
                    visit[i] = true;
                    q.offer(new ConnectSomeIndex(temp.end, i));
                }
            }
        }
    }
}

class ConnectSomeIndex {
    int start;
    int end;

    ConnectSomeIndex(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
