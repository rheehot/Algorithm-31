package Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class NaverOne {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(solution("kkaxbycyz", "abc"));
        bw.write("\n");
        bw.write(solution("acbbcdc", "abc"));

        bw.flush();
        bw.close();
    }

    public static String solution(String m, String k) {
        int mIndex = 0;
        int kIndex = 0;

        String answer = "";
        while(mIndex < m.length()) {
            char mTemp = m.charAt(mIndex);
            // 다 찾았음
            if(kIndex == k.length()) {
                answer += m.substring(mIndex);
//                answer += mTemp;
//                mIndex++;
//                continue;
                return answer;
            }
            char kTemp = k.charAt(kIndex);
            // 암호
            if(mTemp == kTemp) {
                mIndex++;
                kIndex++;
                continue;
            }

            // 암호 아님
            mIndex++;
            answer += mTemp;
        }

        return answer;

    }
}
