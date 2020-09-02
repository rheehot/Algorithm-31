package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Retire {
    public static int N;
    public static int[][] table;
    public static int[] visit;
    public static int answer = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        // 0: 날짜, 1: 금액
        table = new int[N + 1][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            table[i][0] = Integer.parseInt(st.nextToken());
            table[i][1] = Integer.parseInt(st.nextToken());
        }

        solution(0, 0);
        bw.write(answer + "");

        bw.flush();
        bw.close();
    }

    public static void solution(int day, int money) {
         if(day >= N) {
             answer = Math.max(answer, money);
             return;
         }

         if(day + table[day][0] <= N)
             solution(day + table[day][0], money + table[day][1]);

         solution(day + 1, money);
    }
}
