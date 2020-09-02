package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BlackJack {
    public static int N;
    public static int M;
    public static int answer = 0;
    public static int[] cards;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        cards = new int[st.countTokens()];
        for(int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        solution(0, 0, 0);

        bw.write(answer+"");

        bw.flush();
        bw.close();
    }

    public static void solution(int index, int sum, int count) {
        if(count > 3) {
            return;
        }
        if(sum > M) {
            return;
        }
        if(index >= N) {
            if(count == 3) {
                answer = (Math.max(answer, sum));
            }
            return;
        }

        solution(index + 1, sum, count);
        solution(index + 1, sum + cards[index], count + 1);
    }
}
