package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATM {
    static int[] people;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        people = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(people);

        int[] visit = new int[N];
        visit[0] = people[0];
        for(int i = 1; i < N; i++) {
            visit[i] = visit[i - 1] + people[i];
        }

        int count = 0;
        for(int i = 0; i < N; i++) {
            count += visit[i];
        }

        bw.write(count+"");

        bw.flush();
        bw.close();
    }
}
