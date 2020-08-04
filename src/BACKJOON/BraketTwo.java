package BACKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BraketTwo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String str = br.readLine();
            if(str.equals(".")) {
                break;
            }

            Stack<Character> s = new Stack<>();

            boolean flag = true;
            for(int index = 0; index < str.length(); index++) {
                Character c = str.charAt(index);

                if(c == '(' || c == '[') {
                    s.push(c);
                }
                else if (c == ')') {
                    if(s.isEmpty() || s.peek() != '(') {
                        flag = false;
                        break;
                    }

                    s.pop();
                }
                else if (c == ']') {
                    if(s.isEmpty() || s.peek() != '[') {
                        flag = false;
                        break;
                    }

                    s.pop();
                }
            }

            if(flag) {
                if(s.isEmpty()) {
                    System.out.println("yes");
                }
                else {
                    System.out.println("no");
                }
            }
            else {
                System.out.println("no");
            }
        }
    }
}
