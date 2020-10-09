package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ1072 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());
        long z = y * 100 / x;

        if(z >= 99) {
            bw.write("-1");
        }
        else {
            long start = 0;
            long end = x;

            while(start <= end) {
                long middle = (start + end) / 2;

                long temp = (y + middle) * 100 / (x + middle);
                if(temp > z) {
                    end = middle - 1;
                }
                else {
                    start = middle + 1;
                }
            }

            bw.write(start + "");
        }
        bw.flush();
        bw.close();
    }
}
