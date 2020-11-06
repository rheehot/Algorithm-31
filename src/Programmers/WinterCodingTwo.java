package Programmers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class WinterCodingTwo {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solution("qyyigoptvfb", "abcdefghijk", 3);
        bw.flush();
        bw.close();
    }

    public static String solution(String encrypted_text, String key, int rotation) {
        int r = Math.abs(rotation) % encrypted_text.length();
        String temp = "";
        if(r == 0 || encrypted_text.length() == 1) {
            temp = encrypted_text;
        }
        // 양수로 로테이션
        else if(rotation > 0) {
            temp = encrypted_text.substring(r);
            temp += encrypted_text.substring(0, r);
        }
        // 음수로 로테이션
        else {
            r = encrypted_text.length() - r;
            temp = encrypted_text.substring(r);
            temp += encrypted_text.substring(0, r);
        }

        String answer = "";
        for(int index = 0; index < key.length(); index++) {

            int i = temp.charAt(index) - key.charAt(index) - 1;
            if(i < 0) {
                i += 26;
            }

            answer += (char)('a' + i);

        }
        System.out.println(answer);
        return answer;
    }
}
