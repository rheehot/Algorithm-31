package BACKJOON;

import java.io.*;
import java.util.Stack;

public class Braket {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            Stack<Character> s = new Stack<>();
            String str = br.readLine();

            boolean result = true;
            for(int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '(') {
                    s.push(str.charAt(j));
                }
                else if(str.charAt(j) == ')') {
                    if (s.isEmpty()) {
                        result = false;
                        break;
                    }
                    else {
                        s.pop();
                    }
                }
            }

            if (result) {
                if (!s.isEmpty()) {
                    System.out.println("NO");
                }
                else {
                    System.out.println("YES");
                }
            }
            else {
                System.out.println("NO");
            }
        }
    }
}
