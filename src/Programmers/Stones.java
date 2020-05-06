package Programmers;

import java.util.Scanner;

public class Stones {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] stones = new int[n];

        for(int i = 0; i < n; i++) {
            stones[i] = scan.nextInt();
        }
        int k = scan.nextInt();
        System.out.println(solution(stones, k));
    }

    public static int result = 0;
    public static int solution(int[] stones, int k) {
        int[] s = new int[stones.length + 1];
        for(int i = 1; i < s.length; i++) {
            s[i] = stones[i - 1];
        }
//        dfs(stones, k, 0);
        dfs2(s, k, 0);
        return result;
    }

    public static void dfs(int[] stones, int k, int niniz) {

        int index = -1;
        while(true) {
            boolean flag = true;
            for(int i = 1; i <= k; i++) {
                if (index + i >= stones.length) {
                    dfs(stones, k, niniz + 1);
                    return;
                }
                // 징검다리로 이동
                if(stones[index + i] > 0) {
                    index = index + i;
                    stones[index]--;
                    flag = false;
                    break;
                }
            }
            // 이동할 곳이 없음
            if(flag) {
                if (result < niniz) {
                    result = niniz;
                    return;
                }
            }
        }
    }

    public static void dfs2(int[] stones, int k, int niniz) {
        for(int i = 1; i < stones.length; i++) {
            if(stones[i] <= 0) {
                
            }
        }
    }
}
