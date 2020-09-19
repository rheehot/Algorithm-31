package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BuyCard {
    static int N;
    static int[] prices;
    static int[] answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        prices = new int[N + 1];
        answer = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int index = 1; index <= N; index++) {
            prices[index] = Integer.parseInt(st.nextToken());
            answer[index] = prices[index];
        }

        if(N == 1) {
            bw.write(prices[1] + "\n");
        }
        else {
            for(int index = 2; index <= N; index++) {
                judge(index);
            }
            bw.write(answer[N] + "\n");
        }

        bw.flush();
        bw.close();
    }

    public static void judge(int index) {
        int pivot = (index + 1) / 2;
        for(int i = index - 1; i >= pivot; i--) {
            if(answer[index] < answer[i] + answer[index - i]) {
                answer[index] = answer[i] + answer[index - i];
            }
        }
    }
}
