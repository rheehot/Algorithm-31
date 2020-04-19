package src.Programmers;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/42587?language=java
 */

import java.util.LinkedList;
import java.util.Queue;

public class Printer {
    class Print {
        int grade;
        boolean target;

        Print(int grade, boolean target) {
            this.grade = grade;
            this.target = target;
        }
    }

    public int solution(int[] priorities, int location) {
        Queue<Print> printer = new LinkedList<>();
        int[] prioritiArr = new int[10];

        for(int i = 0; i < priorities.length; i++) {
            printer.add(new Print(priorities[i], (i == location) ? true : false));
            prioritiArr[priorities[i]]++;
        }

        int count = 0;
        while(!printer.isEmpty()) {
            Print j = printer.remove();

            boolean flag = true;
            for(int i = j.grade + 1; i < 10; i++) {
                if (prioritiArr[i] > 0) {
                    flag = false;
                    break;
                }
            }

            // j가 최우선
            if (flag) {
                count++;
                prioritiArr[j.grade]--;
                if(j.target) {
                    return count;
                }
            }
            // j보다 우선순위 높은게 존재
            else {
                printer.add(j);
            }
        }

        return priorities.length;
    }
}