package Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class NHNThree {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.flush();
        bw.close();
    }

//    public static void solution(int numOfOrder, String[] orderArr) {
//        for(int i = 0; i < numOfOrder; i++) {
////            System.out.println(order(orderArr[numOfOrder]));
//        }
//    }
//    public static String order(String origin) {
//        Stack<String> s = new Stack<>();
//        for(int i = 0; i < origin.length(); i++) {
//            char t = origin.charAt(i);
//            if(t >= '1' && t <= '9') {
//
//            }
//
//        }
//    }


    public static String order(String origin) {
        Stack<Character> s = new Stack<>();
        String answer = "";
        for(int i = 0; i < origin.length(); i++) {
            s.push(origin.charAt(i));
        }
        int count = 0;
        String o = "";
        while(!s.isEmpty()) {
            char temp = s.pop();
            if(temp == ')') {
                count++;
            }
            if(temp == '(') {
                count--;

                if(count == 0) {
                    if(s.peek() == ')') {
                        o = "";
                        continue;
                    }
                    // 숫자만큼
                    if(s.peek() >= '1' && s.peek() <= '9') {
                        for(int i = 0; i < s.peek() - '0'; i++) {
                            answer = answer + o;
                        }
                        o = "";
                        s.pop();
                    }
                    // 문자
                    else {
                        char add = s.pop();
                        for(int i = 0; i < o.length(); i++) {
                            answer += add + o.charAt(i);
                        }
                        o = "";
                    }
                    continue;
                }
            }

        }
        return answer;
    }
}
