package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class CutLan {
    public static int[] lan;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        lan = new int[K];

        long max = Integer.MIN_VALUE;
        for(int i = 0; i < K; i++) {
            lan[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, lan[i]);
        }

        long start = 1;
        long end = max;
        long middle;
        long answer = 0;
        while(start <= end) {
            middle = (start + end) / 2;
            long n = cut(middle);

            if(n >= N) {
                answer = Math.max(answer, middle);
                start = middle + 1;
            }
            else {
                end = middle - 1;
            }
        }

        bw.write(answer+"");

        bw.flush();
        bw.close();
    }

    public static long cut(long m) {
        long sum = 0;
        for(int i = 0; i < lan.length; i++) {
            sum += (lan[i] / m);
        }
        return sum;
    }
}
