package Programmers;

import java.util.HashSet;
import java.util.Scanner;

public class Delivery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int k = scan.nextInt();

        int[][] road = new int[k][3];
        for(int i = 0; i < k; i++) {
            for(int j = 0; j < 3; j++) {
                road[i][j] = scan.nextInt();
            }
        }

        int K = scan.nextInt();

        System.out.println(solution(N, road, K));
    }

    public static int solution(int N, int[][] road, int K) {
        int[][] map = new int[N + 1][N + 1];
        boolean[] visit = new boolean[N + 1];

        for(int index = 0; index < road.length; index++) {
            int i = road[index][0];
            int j = road[index][1];

            if (map[i][j] != 0) {
                if (map[i][j] > road[index][2]) {
                    map[i][j] = road[index][2];
                    map[j][i] = road[index][2];
                }
            }
            else {
                map[i][j] = road[index][2];
                map[j][i] = road[index][2];
            }
        }

        result.add(1);
        visit[1] = true;

        for(int j = 1; j < map.length; j++) {
            if(map[1][j] != 0 && map[1][j] <= K) {
                visit[j] = true;
                result.add(j);
                dfs(map, visit, j, K, map[1][j]);
                visit[j] = false;
            }
        }

        return result.size();
    }

    static HashSet<Integer> result = new HashSet<>();
    static int[][] visit;

    public static int solution2(int N, int[][] road, int K) {
         int[][] map = new int[N + 1][N + 1];
         visit = new int[N + 1][N + 1];

         for(int index = 0; index < road.length; index++) {

             int i = road[index][0];
             int j = road[index][1];

             if (map[i][j] != 0) {
                 if (map[i][j] > road[index][2]) {
                     map[i][j] = road[index][2];
                     map[j][i] = road[index][2];
                 }
             }
             else {
                 map[i][j] = road[index][2];
                 map[j][i] = road[index][2];
             }
         }

         result.add((1));

         for(int j = 1; j < map.length; j++) {
             if(map[1][j] != 0 && map[1][j] <= K) {
                 visit[1][j] = map[1][j];
                 visit[j][1] = map[j][1];
                 result.add(j);
                 dfs2(map, j, K, map[1][j]);
             }
         }

         return result.size();
    }

    public static void dfs2(int[][] map, int start, int K, int count) {
        for(int j = 1; j < map.length; j++) {
            if (map[start][j] != 0 && map[start][j] + count <= K) {
                if (visit[start][j] == 0) {
                    visit[start][j] = map[start][j] + count;
                    visit[j][start] = map[start][j] + count;
                    result.add(j);
                    dfs2(map, j, K, map[start][j] + count);
                }
                else if(map[start][j] + count < visit[start][j]) {
                    visit[start][j] = map[start][j] + count;
                    visit[j][start] = map[start][j] + count;
                    result.add(j);
                    dfs2(map, j, K, map[start][j] + count);
                }
            }
        }
    }

    public static void dfs(int[][] map, boolean[] visit, int start, int K, int count) {
        for(int j = 1; j < map.length; j++) {
            if (visit[j]) {
                continue;
            }
            if (map[start][j] != 0 && map[start][j] + count <= K) {
                visit[j] = true;
                result.add(j);
                dfs(map, visit, j, K, map[start][j] + count);
                visit[j] = false;
            }
        }
    }

}
