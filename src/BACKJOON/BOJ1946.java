package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ1946 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            int[] s = new int[n + 1];
            for(int index = 0; index < n; index++) {
                st = new StringTokenizer(br.readLine());
                s[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
            }
            bw.write(solution(s) + "\n");
        }

        bw.flush();
        bw.close();
    }

    public static int solution(int[] s) {
        int max = 1;
        int count = 0;
        boolean[] v = new boolean[s.length];
        v[1] = true;
        for(int i = s.length - 1; i >= 0; i--) {
            if(s[i] > max) {
                v[s[i]] = true;
                continue;
            }
            if(s[i] == max) {
                count++;
                max++;
                while(max < v.length && v[max]){
                    max++;
                }
            }
        }
        return count;
    }
}
