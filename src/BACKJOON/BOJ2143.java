package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2143 {
    static int T;
    static int n, m;
    static int[] A;
    static int[] B;

    static int answer = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        A = new int[n];
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());
        B = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> list = new ArrayList<>();


        bw.write(answer + "");
        bw.flush();
        bw.close();
    }
}
