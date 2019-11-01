package src.Programmers;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/42587?language=java
 */

import java.util.*;
public class Printer {
    public static int solution(int[] priorities, int location) {
        int[] priority = new int[10];
        Queue<Print> priorityQ = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++) {
            priority[priorities[i]]++;
            priorityQ.add(new Print(i, priorities[i]));
        }

        int answer = 0;
        while(true) {
            Print temp = priorityQ.remove();

            boolean isBig = false;
            for(int i = 1; i < priority.length; i++) {
                if (i > temp.priority && priority[i] > 0) {
                    priorityQ.add(temp);
                    isBig = true;
                    break;
                }
            }

            if (isBig) {
                continue;
            }

            answer++;
            priority[temp.priority]--;
            if(temp.location == location) {
                break;
            }
        }

        return answer;
    }
}

class Print {
    int location;
    int priority;

    Print(int location, int priority) {
        this.location = location;
        this.priority = priority;
    }
}
