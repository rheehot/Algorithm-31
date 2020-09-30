package Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class StreetThree {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(solution("aabab") + "\n");
        bw.write(solution("dog") + "\n");
        bw.write(solution("aa") + "\n");
        bw.write(solution("aaa") + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(String s) {
        if(s.contains("aaa")) {
            return -1;
        }

        int count = 0;
        for(int index = 0; index < s.length(); index++) {
            if(s.charAt(index) != 'a') {
                count++;
            }
        }

        int answer = (count + 1) * 2;
        answer += count;
        return answer - s.length();
    }
}
