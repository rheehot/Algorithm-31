package src.JAVA;

import java.util.*;
public class Combination {
    public static void main(String[] args) {
    }

    // 백트래킹 사용
    static void combinationWithBackTracking(int[] arr, boolean[] visited, int start, int n, int r) {
        if(r == 0) {
            return;
        }
        else {
            for(int i = start; i < n; i++) {
                visited[i] = true;
                combinationWithBackTracking(arr, visited, i + 1, n, r - 1);
                visited[i] = false;
            }
        }
    }

    // 재귀 사용
    static void combination(int[] arr, boolean[] visited, int depth, int n, int r) {
        if(r == 0) {
            return;
        }
        if(depth == n) {
            return;
        }
        else {
            visited[depth] = true;
            combination(arr, visited, depth + 1, n, r - 1);
            visited[depth] = false;
            combination(arr, visited, depth + 1, n, r);
        }
    }
}