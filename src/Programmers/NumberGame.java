package src.Programmers;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/12987?language=java
 */

import src.HackerRank.Array;

import java.util.*;
public class NumberGame {

    public static int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int answer = 0;

        for(int i = A.length - 1, j = B.length - 1; i >= 0; i--) {
            if (A[i] < B[j]) {
                answer++;
                j--;
            }
        }
        return answer;
    }
}
