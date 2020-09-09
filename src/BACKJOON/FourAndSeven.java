package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FourAndSeven {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(br.readLine());

        String answer = "";
        while(K > 0) {
            if(K % 2 == 0) {
                answer = "7" + answer;
                K = (K - 2) / 2;
            }
            else {
                answer = "4" + answer;
                K = (K - 1) / 2;
            }
        }


        bw.write(answer);
        bw.flush();
        bw.close();
    }
}
