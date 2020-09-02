package BACKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumPart {
    public static int[] arr;
    public static int S;
    public static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution(0, 0);
        if(S == 0) {
            answer--;
        }
        System.out.println(answer);
    }

    public static void solution(int sum, int i) {
        if(i == arr.length) {
            if(sum == S) {
                answer++;
            }
            return;
        }

        solution(sum + arr[i], i + 1);
        solution(sum, i + 1);
    }
}
