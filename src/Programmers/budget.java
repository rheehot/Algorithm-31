package src.Programmers;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/12982?language=java
 */

import java.util.*;
public class budget {
    static int solution(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d);
        int sum = 0;
        for(int i = 0; i < d.length; i++) {
            if (sum + d[i] <= budget) {
                answer ++;
                sum += d[i];
            }
            else {
                break;
            }
        }

        return answer;
    }
}
