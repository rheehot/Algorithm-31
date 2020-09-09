package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class JudgeString {
    static String s;
    static String[] arr;
    static int answer = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        s = br.readLine();
        int N = Integer.parseInt(br.readLine());
        arr = new String[N];
        for(int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        judge(s);
        bw.write(answer + "");

        bw.flush();
        bw.close();
    }

    public static void judge(String r) {

        if(r.length() == 0) {
            answer = 1;
            return;
        }

        for(int i = 0; i < arr.length; i++) {
            if(arr[i].length() > r.length()) {
                continue;
            }
            String temp = r.substring(0, arr[i].length());
            if(temp.equals(arr[i])) {
                judge(r.substring(arr[i].length()));
            }
        }
    }
}
