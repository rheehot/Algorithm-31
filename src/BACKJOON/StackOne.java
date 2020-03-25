package BACKJOON;

import java.io.*;
import java.util.*;

public class StackOne {
    public static void main(String[] args) throws IOException {
        Stack<Integer> s = new Stack<Integer>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            String[] temp = br.readLine().split(" ");
            String m = temp[0];

            if (m.equals("push")) {
                s.push(Integer.parseInt(temp[1]));
            }
            else if (m.equals("pop")) {
                if (s.isEmpty()) {
                    System.out.println("-1");
                }
                else {
                    System.out.println(s.pop());
                }
            }
            else if (m.equals("size")) {
                System.out.println(s.size());
            }
            else if (m.equals("empty")) {
                if (s.isEmpty()) {
                    System.out.println("1");
                }
                else {
                    System.out.println("0");
                }
            }
            else if (m.equals("top")) {
                if (s.isEmpty()) {
                    System.out.println("-1");
                }
                else {
                    System.out.println(s.peek());
                }
            }
        }
    }
}
