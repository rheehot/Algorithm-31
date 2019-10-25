package src.Programmers;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/43165
 */

import java.util.*;
public class TargetNumber {
    public static int solution(int[] numbers, int target) {
        int answer = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(numbers[0]);
        q.add(numbers[0] * -1);

        for(int i = 1; i < numbers.length; i++) {
            int length = q.size();

            for(int j = 0; j < length; j++) {
                int origin= q.poll();
                q.add(origin + numbers[i]);
                q.add(origin - numbers[i]);
            }
        }

        while(!q.isEmpty()) {
            int qNumber = q.poll();
            if (qNumber == target) {
                answer++;
            }
        }

        return answer;
    }
}
