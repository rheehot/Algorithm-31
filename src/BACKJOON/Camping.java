package BACKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Camping {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer("");
        int tc = 1;
        while(true) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            if(L == 0 && P == 0 && V == 0) {
                break;
            }

            int answer = 0;
            answer += (V / P) * L;

            int retainDay = V % P;
            if(L <= retainDay) {
                answer += L;
            }
            else {
                answer += retainDay;
            }

            sb.append("Case " + tc + ": " + answer + "\n");
            tc++;
        }

        System.out.println(sb);
    }
}
