package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class LostBraket {
    static String str;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        str = br.readLine();

        int answer = 0;
        String[] arr = str.split("-");
        for(int i = 0; i < arr.length; i++) {
            if(arr[i].equals("")) {
                continue;
            }

            String temp = arr[i];
            String[] t = temp.split("\\+");

            int sum = 0;
            for(int j = 0; j < t.length; j++) {
                if (t[j].equals("")) {
                    continue;
                }
                sum += Integer.parseInt(t[j]);
            }

            if(i == 0) {
                answer = sum;
            }
            else {
                answer -= sum;
            }
        }

        bw.write(answer+"");

        bw.flush();
        bw.close();
    }
}
