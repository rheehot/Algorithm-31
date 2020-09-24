package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class GoodSuYul {
    static int n;
    static String answer = "";
    static boolean flag = false;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        add("1");

        bw.write(answer);
        bw.flush();
        bw.close();
    }

    public static void add(String str) {
        if(flag) {
            return;
        }

        if(str.length() == n) {
            answer = str;
            flag = true;
            return;
        }

        for(int i = 1; i <= 3; i++) {
            if(str.charAt(str.length() - 1) - '0' == i) {
                continue;
            }

            if(str.length() + 1 < 4) {
                add(str + i);
            }
            else if(check(str + i)) {
                add(str + i);
            }
        }
    }

    public static boolean check(String str) {
        int len = str.length();
        int k = 2;
        while(k <= len / 2) {
            if(str.substring(len - k, len).equals(str.substring(len - (2 * k), len - k))) {
                return false;
            }
            k++;
        }

        return true;
    }
}
