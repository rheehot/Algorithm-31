package BACKJOON;

import java.util.Scanner;

public class StartAndLink {
    public static int[][] map;
    public static int[] visit;
    public static int N;

    public static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        map = new int[N][N];
        visit = new int[N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                map[i][j] = scan.nextInt();
            }
        }

        matching(0, 0);
        System.out.println(answer);
    }

    public static void matching(int start, int count) {
        if(count == (N / 2)) {
            calc();
            return;
        }

        for(int i = start; i < N; i++) {
            visit[i] = 1;
            matching(i + 1, count + 1);
            visit[i] = 0;
        }
    }

    public static void calc() {
        int[] start = new int[N / 2];
        int[] link = new int[N / 2];
        int startCount = 0;
        int linkCount = 0;
        int startSum = 0;
        int linkSum = 0;

        for(int i = 0; i < N; i++) {
            if(visit[i] == 1) {
                start[startCount++] = i;
            }
            else {
                link[linkCount++] = i;
            }
        }

        for(int i = 0; i < N / 2; i++) {
            for(int j = i + 1; j < N / 2; j++) {
                startSum += map[start[i]][start[j]] + map[start[j]][start[i]];
                linkSum += map[link[i]][link[j]] + map[link[j]][link[i]];
            }
        }

        answer = Math.min(answer, Math.abs(startSum - linkSum));
    }
}
