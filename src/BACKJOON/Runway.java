package BACKJOON;

import java.util.Scanner;

public class Runway {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int l = scan.nextInt();

        int[][] map = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                map[i][j] = scan.nextInt();
            }
        }

        int count = 0;

        // 가로 방향
        for(int i = 0; i < n; i++) {
            int[] x = new int[n];
            int[] y = new int[n];
            for(int j = 0; j < n; j++) {
                x[j] = map[i][j];
                y[j] = map[j][i];
            }

            count += canGo(x, n, l);
            count += canGo(y, n, l);
        }

        System.out.println(count);
    }

    public static int canGo(int[] map, int n, int l) {
        boolean[] visit = new boolean[n];

        for(int i = 0; i < n - 1; i++) {
            // 높이 차이가 1보다 크면 안됨
            if (Math.abs(map[i] - map[i + 1]) > 1) {
                return 0;
            }

            // 앞의 높이가 더 높다면 (오르막) -> 뒤의 길이 l의 길이만큼 필요
            if (map[i + 1] - map[i] > 0) {
                if(visit[i]) {
                    return 0;
                }
                for(int j = 1; j < l; j++) {
                    // map을 넘어감
                    if (i - j < 0) {
                        return 0;
                    }
                    // 평평한 땅이 아님
                    if (map[i] != map[i - j]) {
                        return 0;
                    }

                    if(visit[i - j]) {
                        return 0;
                    }

                    visit[i - j] = true;
                }
                visit[i] = true;
            }
            // 앞의 높이가 더 작다면 (내리막) -> 앞의 길이 l의 길이만큼 필요
            else if (map[i + 1] - map[i] < 0) {
                if (visit[i + 1]) {
                    return 0;
                }
                for(int j = 1; j < l; j++) {
                    // map을 넘어감
                    if(i + j + 1 > n - 1) {
                        return 0;
                    }
                    //평평한 땅이 아님
                    if (map[i + 1] != map[i + 1 + j]) {
                        return 0;
                    }

                    // 이미 다리를 놓음
                    if (visit[i + 1 + j]) {
                        return 0;
                    }

                    visit[i + 1 + j] = true;
                }
                visit[i + 1] = true;
            }
            // 높이가 같다면 그대로
        }

        return 1;
    }
}
