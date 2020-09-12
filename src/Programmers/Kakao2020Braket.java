package Programmers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// 14:00
public class Kakao2020Braket {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String p = br.readLine();
        bw.write(solution(p));

        bw.flush();
        bw.close();
    }

    static int position = 0;
    public static String solution(String p) {
        if(p.isEmpty()) {
            return p;
        }
        boolean correct = isCorrect(p);

        String u = p.substring(0, position);
        String v = p.substring(position);

        if(correct) {
            return u + solution(v);
        }

        String answer = "(" + solution(v) + ")";
        for(int i = 1; i < u.length() - 1; i++) {
            if(u.charAt(i) == '(') {
                answer += ')';
            }
            else {
                answer += '(';
            }
        }

        return answer;
    }

    public static boolean isCorrect(String s) {
        int left = 0;
        int right = 0;

        Stack<Character> stack = new Stack<>();
        boolean ret = true;
        for(int i = 0; i < s.length(); i++) {
            char t = s.charAt(i);
            if(t == ')') {
                right++;
                if(stack.isEmpty()) {
                    ret = false;
                }
                stack.pop();
            }
            else {
                left++;
                stack.push(t);
            }

            if(left == right) {
                position = i + 1;
                return ret;
            }
        }

        return true;
    }
}
