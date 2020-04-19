package BACKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class QueueTwo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        int rear = 0;

        for(int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");

            if (str[0].equals("push")) {
                rear = Integer.parseInt(str[1]);
                q.add(Integer.parseInt(str[1]));
            }
            else if (str[0].equals("pop")) {
                if (q.isEmpty()) {
                    System.out.println("-1");
                }
                else {
                    System.out.println(q.remove());
                }
            }
            else if(str[0].equals("size")) {
                System.out.println(q.size());
            }
            else if(str[0].equals("empty")) {
                if (q.isEmpty()) {
                    System.out.println("1");
                }
                else {
                    System.out.println("0");
                }
            }
            else if (str[0].equals("front")) {
                if (q.isEmpty()) {
                    System.out.println("-1");
                }
                else {
                    System.out.println(q.peek());
                }
            }
            else if (str[0].equals("back")) {
                if(q.isEmpty()) {
                    System.out.println("-1");
                }
                else {
                    System.out.println(rear);
                }
            }
        }
    }
}
