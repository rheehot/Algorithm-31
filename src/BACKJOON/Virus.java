package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Virus {
    public static int[] computers;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        computers = new int[N + 1];
        for(int i = 1; i < computers.length; i++) {
            computers[i] = i;
        }

        for(int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int count = 0;
        for(int i = 2; i <= N; i++) {
            if(find(1) == find(i)) {
                count++;
            }
        }
        bw.write(count + "");

        bw.flush();
        bw.close();
    }

    public static int find(int n) {
        if(n == computers[n]) {
            return n;
        }
        else {
            return computers[n] = find(computers[n]);
        }
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x != y) {
            computers[y] = x;
        }
    }
}
