package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IPv6 {
    static String[] str = new String[8];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String origin = br.readLine();

        String temp = "";
        int index = 0;
        int count = 0;

        String answer = "";
        for(int i = 0; i < origin.length(); i++) {
            char t = origin.charAt(i);

            if(t == ':') {

                if(temp.length() == 4) {
                    answer += temp;
                    answer += ":";
                }
                else {
                    answer += check(temp);
                    answer += ":";
                }
                temp = "";

                if(origin.charAt(i + 1) == ':') {
                    index = answer.length();
                    i++;
                }
                continue;
            }

            temp += t;
        }

        if(!temp.equals("")) {
            answer += check(temp);
        }
        while(answer.length() != 39) {
            String f = answer.substring(0, index);
            String b = answer.substring(index);

            answer = f + check("0") + ":" + b;
            if(answer.charAt(answer.length() - 1) == ':') {
                answer = answer.substring(0, answer.length() - 1);
            }
        }

        bw.write(answer);
        bw.flush();
        bw.close();
    }

    static String check(String str) {
        int len = str.length();
        while(str.length() != 4) {
            str = "0" + str;
        }

        return str;
    }
}
