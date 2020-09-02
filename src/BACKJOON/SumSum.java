package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SumSum {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String N = br.readLine();
        int n = Integer.parseInt(N);
        n -= (N.length() * 9);

        int ans = 0;
        for(int i = n; i < Integer.parseInt(N); i++) {
            int sum = i;
            int k = i;
            while(k > 0) {
                sum += k%10;
                k /= 10;
            }

            if(sum == Integer.parseInt(N)) {
                ans = i;
                break;
            }
        }

        bw.write(ans+"");
        bw.flush();
        bw.close();
    }
}
