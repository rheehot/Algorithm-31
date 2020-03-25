package BACKJOON;

import java.util.Scanner;
import java.util.Stack;

public class Zero {
    public static void main(String[] args)  {
        Scanner scan = new Scanner(System.in);
        int K = scan.nextInt();
        Stack<Integer> s = new Stack<Integer>();
        for(int i = 0; i < K; i++) {
            int m = scan.nextInt();

            if (m == 0) {
                s.pop();
            }
            else {
                s.push(m);
            }
        }

        int result = 0;
        while(!s.isEmpty()) {
            result += s.pop();
        }

        System.out.println(result);
    }
}
