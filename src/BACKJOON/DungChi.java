package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class DungChi {
    public static int N;
    public static int[][] p;
    public static int[] answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        p = new int[N][2];
        answer = new int[N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            p[i][0] = Integer.parseInt(st.nextToken());
            p[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            solution(i);
        }

        for(int i = 0; i < N; i++) {
            bw.write((answer[i] + 1) + " ");
        }

        bw.flush();
        bw.close();
    }

    public static void solution(int index) {
        int count = 0;

        for(int i = 0; i < N; i++) {
            if(i == index) {
                continue;
            }

            if(p[index][0] < p[i][0] && p[index][1] < p[i][1]) {
                count++;
            }
        }

        answer[index] = count;
    }
}
