package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class Calculate {
    static String str;

    static Deque<String> q = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        str = br.readLine();

        // 수식이 없음
        if(!check()) {
            bw.write(Long.parseLong(str) + "");
        }
        else {
            bw.write(cal() + "");
        }

        bw.flush();
        bw.close();
    }

    // 계산하기
    public static long cal() {
        while(!q.isEmpty()) {
            if(q.size() == 3) {
                break;
            }

            String frontNum = q.pollFirst();
            String backNum = q.pollLast();

            String frontStr = q.pollFirst();
            String backStr =  q.pollLast();

            // 앞
            if((frontStr.equals("*") || frontStr.equals("/")) && (backStr.equals("+") || backStr.equals("-"))) {
                q.addLast(backStr);
                q.addLast(backNum);

                long front = Long.parseLong(frontNum);
                long front2 = Long.parseLong(q.pollFirst());

                long r = 0;
                if(frontStr.equals("*")) {
                    r = front * front2;
                }
                else {
                    r = front / front2;
                }

                q.addFirst(r + "");
            }
            // 뒤
            else if((frontStr.equals("+") || frontStr.equals("-")) && (backStr.equals("*") || backStr.equals("/"))) {
                q.addFirst(frontStr);
                q.addFirst(frontNum);

                long back = Long.parseLong(backNum);
                long back2 = Long.parseLong(q.pollLast());

                long r = 0;
                if(backStr.equals("*")) {
                    r = back * back2;
                }
                else {
                    r = back2 / back;
                }

                q.addLast(r + "");
            }
            else {
                long front = c(frontNum, frontStr, q.peekFirst());
                long back = c(q.peekLast(), backStr, backNum);

                if(front >= back) {
                    q.pollFirst();
                    q.addLast(backStr);
                    q.addLast(backNum);

                    q.addFirst(front + "");
                }
                else {
                    q.pollLast();
                    q.addFirst(frontStr);
                    q.addFirst(frontNum);

                    q.addLast(back + "");
                }
            }
        }

        long answer = c(q.pollFirst(), q.pollFirst(), q.pollFirst());
        return answer;
    }

    public static long c(String fNum, String s, String bNum) {
        long r = 0;
        switch(s) {
            case "+":
                r = Long.parseLong(fNum) + Long.parseLong(bNum);
                break;
            case "-":
                r = Long.parseLong(fNum) - Long.parseLong(bNum);
                break;
            case "*":
                r = Long.parseLong(fNum) * Long.parseLong(bNum);
                break;
            case "/":
                r = Long.parseLong(fNum) / Long.parseLong(bNum);
                break;
        }

        return r;
    }

    // 수식이 있는지 없는지 확인
    public static boolean check() {

        boolean flag = false;
        String temp = "";
        for(int i = 0; i < str.length(); i++) {
            char t = str.charAt(i);

            // 음수
            if(i == 0 && t == '-') {
                temp += t;
                continue;
            }

            if(t == '*' || t == '/' || t == '+' || t == '-') {
                q.addLast(temp);
                temp = "";
                q.addLast(t + "");
                flag = true;
                continue;
            }

            temp += t;
        }
        q.addLast(temp);

        return flag;
    }


}
