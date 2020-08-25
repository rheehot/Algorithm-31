package BACKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class GoodWord {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int answer = 0;
        for(int i = 0; i < T; i++) {
            if(solution(br.readLine())) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static boolean solution(String str) {
        Stack<Character> s = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            if(s.isEmpty()) {
                s.push(str.charAt(i));
            }
            else {
                if(s.peek() == str.charAt(i)) {
                    s.pop();
                    continue;
                }
                s.push(str.charAt(i));
            }
        }

        if(s.isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }
}
