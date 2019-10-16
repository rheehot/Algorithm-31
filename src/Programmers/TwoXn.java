package src.Programmers;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/12900?language=java
 */

import java.util.*;
public class TwoXn {
    static int solution(int n) {
        int[] answer = new int[n + 1];
        answer[1] = 1;
        answer[2] = 2;
        if (n <= 2) {
            return answer[n];
        }
        int d = 1000000007;
        for(int i = 3; i <= n; i++) {
            answer[i] = answer[i - 2] + answer[i - 1];
            answer[i] %= d;
        }
        return answer[n];
    }
}
