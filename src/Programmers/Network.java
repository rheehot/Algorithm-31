package src.Programmers;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/43162
 */

import java.util.*;
public class Network {
    static boolean visited[];
    public static int solution(int n, int[][] computers) {
        int answer = 0;

        visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(computers, i, n);
                answer++;
            }
        }

        return answer;
    }

    public static void dfs(int[][] computers, int index, int n) {
        visited[index] = true;
        for(int j = 0; j < n; j++) {
            if(!visited[j] && computers[index][j] == 1) {
                dfs(computers, j, n);
            }
        }
    }
}
