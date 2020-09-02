package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class HangSung {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 물이 새는 곳
        int N = Integer.parseInt(st.nextToken());
        // 테이프의 길이
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        double[] water = new double[st.countTokens()];

        if(N == 1) {
            bw.write("1");
            bw.flush();
            bw.close();
            return;
        }

        for(int i = 0; i < N; i++) {
            water[i] = Integer.parseInt(st.nextToken()) - 0.5;
        }

        Arrays.sort(water);

        double tape = water[0] + L;
        int count = 1;

        for(int i = 1; i < N; i++) {
            if(tape >= water[i] + 1) {
                continue;
            }

            tape = water[i] + L;
            count++;
        }

        bw.write(count+"");
        bw.flush();
        bw.close();
    }
}
