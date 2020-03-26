package BACKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class World {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String str = br.readLine();
            if (str.equals(".")) {
                break;
            }

            Stack<Character> s = new Stack<>();

            boolean result = true;
            for(int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '(' || str.charAt(i) == '[') {
                    s.push(str.charAt(i));
                }
                else if (str.charAt(i) == ')') {
                    if (s.isEmpty() || s.peek() != '(') {
                        result = false;
                        break;
                    }

                    s.pop();
                }
                else if (str.charAt(i) == ']') {
                    if (s.isEmpty() || s.peek() != '[') {
                        result = false;
                        break;
                    }


                    s.pop();
                }
            }

            if (result) {
                if (s.isEmpty()) {
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
