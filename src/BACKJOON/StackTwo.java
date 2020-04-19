package BACKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class StackTwo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int num = 1;
        Stack<Integer> s = new Stack<>();

        boolean isAble = true;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());

            if(isAble) {
                if(num <= arr[i]) {
                    while(num <= arr[i]) {
                        s.push(num++);
                        sb.append("+\n");
                    }
                }
                if(s.isEmpty()) {
                    isAble = false;
                }
                else {
                    while(s.peek() >= arr[i]) {
                        s.pop();
                        sb.append("-\n");
                        if(s.isEmpty()) {
                            break;
                        }
                    }
                }
            }
        }
        if(isAble) {
            System.out.println(sb.toString());
        }
        else {
            System.out.println("NO");
        }
    }
}