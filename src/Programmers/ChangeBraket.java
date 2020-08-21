package Programmers;

import java.util.Scanner;
import java.util.Stack;

public class ChangeBraket {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String p = scan.nextLine();

        System.out.println(solution(p));
    }

    public static int position;

    public static String solution(String p) {
        if (p.isEmpty())
            return p;

        boolean correct = isCorrect(p);

        String u = p.substring(0, position);
        String v = p.substring(position, p.length());

        if(correct) {
            return u + solution(v);
        }

        String answer = "(" + solution(v) + ")";

        for(int i = 1; i < u.length() - 1; i++) {
            if(u.charAt(i) == '(') {
                answer += ")";
            }
            else {
                answer += "(";
            }
        }

        return answer;
    }

    public static boolean isCorrect(String str) {
        boolean ret = true;
        int left = 0, right = 0;

        Stack<Character> myStack = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') {
                left++;
                myStack.push('(');
            }
            else {
                right++;
                if(myStack.isEmpty()) {
                    ret = false;
                }
                else {
                    myStack.pop();
                }
            }

            if(left == right) {
                position = i + 1;
                return ret;
            }
        }
        return true;
    }
}
