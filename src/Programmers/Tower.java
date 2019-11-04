package src.Programmers;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/42588?language=java
 */

import java.util.*;
public class Tower {
    public static int[] solution(int[] heights) {
        int len = heights.length;
        int[] answer = new int[len];
        answer[0] = 0;

        for(int i = 1; i < len; i++) {
            int height = heights[i];

            for(int j = i - 1; j >= 0; j--) {
                if(heights[j] > height) {
                    answer[i] = j + 1;
                    break;
                }
            }
        }
        return answer;
    }
}
