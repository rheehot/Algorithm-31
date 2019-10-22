package src.Programmers;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/43162
 */

import java.util.*;
public class Network {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int computers[][] = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                computers[i][j] = scan.nextInt();
            }
        }

        System.out.print(solution(n, computers));
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if (computers[i][j] != 0 && computers[j][i] != 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
