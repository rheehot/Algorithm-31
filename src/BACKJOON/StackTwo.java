package BACKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class StackTwo {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> s = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int curNum = 1;
        for(int i = 0; i < n; i++) {
            int target = Integer.parseInt(br.readLine());

            if(curNum <= target) {
                while(curNum <= target) {
                    s.push(curNum);
                    sb.append("+ \n");
                    curNum++;
                }

                s.pop();
                sb.append("- \n");
                continue;
            }
            else {
                if(s.peek() == target) {
                    s.pop();
                    sb.append("- \n");
                    continue;
                }
                sb.delete(0, sb.length());
                sb.append("NO");
                break;
            }
        }
        System.out.println(sb);
    }
}