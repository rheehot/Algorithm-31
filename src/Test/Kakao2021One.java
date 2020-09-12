package Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Kakao2021One {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String new_id = br.readLine();
        bw.write(solution(new_id));

        bw.flush();
        bw.close();
    }

    public static String solution(String new_id) {
        new_id = new_id.toLowerCase();
        new_id = ruleTwo(new_id);
        new_id = ruleThree(new_id);
        if(new_id != "" && new_id.charAt(0) == '.') {
            new_id = new_id.substring(1);
        }
        if(new_id != "" && new_id.charAt(new_id.length() - 1) == '.') {
            new_id = new_id.substring(0, new_id.length() - 1);
        }

        if(new_id.length() == 0) {
            new_id = "a";
        }
        if(new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            if(new_id.charAt(new_id.length() - 1) == '.') {
                new_id = new_id.substring(0, new_id.length() - 1);
            }
        }

        if(new_id.length() <= 2) {
            while(new_id.length() < 3) {
                new_id += new_id.charAt(new_id.length() - 1);
            }
        }

        return new_id;
    }

    public static String ruleTwo(String s) {
        String answer = "";
        for(int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if(!(temp >= 'a' && temp <= 'z') && !(temp >= '0' && temp <= '9') && (temp != '-') && (temp != '_') && (temp != '.')) {
                continue;
            }
            answer += temp;
        }
        return answer;
    }
    public static String ruleThree(String s) {

        String answer = "";
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if(temp != '.') {
                if(count != 0) {
                    answer += '.';
                    count = 0;
                }
                answer += temp;
                continue;
            }
            count++;
        }

        return answer;
    }
}
