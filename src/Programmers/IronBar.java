package Programmers;

import java.util.Stack;

public class IronBar {
    public int solution(String arrangement) {
        Stack<Character> s = new Stack<>();

        arrangement = arrangement.replace("()", "/");
        int result = 0;

        for(int i = 0; i < arrangement.length(); i++) {
            char c = arrangement.charAt(i);

            // 레이저인 경우
            if (c == '/') {
                result += s.size();
                continue;
            }

            // 쇠막대기가 닫힌 경우
            if (c == ')') {
                s.pop();
                result++;
                continue;
            }

            // 쇠막대기가 열린 경우
            s.push(c);
        }

        return result;
    }
}
