package src.Programmers;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/43163?language=java
 */

import java.util.*;
public class ChangeWord {

    public static int answer = 0;
    public static int solution(String begin, String target, String[] words) {

        boolean[] visited = new boolean[words.length];
        go(begin, target, words, 0, visited);

        return answer;
    }

    public static void go(String begin, String target, String[] words, int num, boolean[] visited) {
        if (begin.equals(target)) {
            if (answer == 0) {
                answer = num;
            }
            else {
                if (answer > num) {
                    answer = num;
                }
            }
            return;
        }

        for(int i = 0; i < words.length; i++) {
            if(!visited[i] && isChange(begin, words[i])) {
                visited[i] = true;
                go(words[i], target, words, num + 1, visited);
                visited[i] = false;
            }
        }
    }

    public static boolean isChange(String b, String l) {
        int n = b.length();
        int t = 0;
        for(int i = 0; i < n; i++) {
            if (b.charAt(i) != l.charAt(i)) {
                t++;
            }
        }
        if (t == 1) {
            return true;
        }
        else {
            return false;
        }
    }
}
