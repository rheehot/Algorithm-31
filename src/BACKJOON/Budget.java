package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Budget {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 지방의 수
        int N = Integer.parseInt(br.readLine());
        // 예산
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] budgets = new int[st.countTokens()];

        int max = 0;
        for(int i = 0; i < budgets.length; i++) {
            budgets[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, budgets[i]);
        }

        int K = Integer.parseInt(br.readLine());

        while(true) {
            int sum = 0;
            for(int i = 0; i < budgets.length; i++) {
                if(budgets[i] > max) {
                    sum += max;
                }
                else {
                    sum += budgets[i];
                }
            }

            if(sum <= K) {
                bw.write(max+"");
                break;
            }
            max--;
        }


        bw.flush();
        bw.close();
    }
}
