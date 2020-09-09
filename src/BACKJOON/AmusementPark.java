package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class AmusementPark {
    static int N, M;
    static int[] attTime;
    static int[] att;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        att = new int[M + 1];
        attTime = new int[M + 1];

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= M; i++) {
            attTime[i] = Integer.parseInt(st.nextToken());
        }

        int n = 0;
        while(n <= N) {
            for(int i = 1; i <= M; i++) {
                if(att[i] == 0) {
                    att[i] = attTime[i];
                    n++;
                    if(n == N) {
                        bw.write(i+"");
                        break;
                    }
                    continue;
                }

                att[i]--;
                if(att[i] == 0) {
                    att[i] = attTime[i];
                    n++;
                    if(n == N) {
                        bw.write(i+"");
                        break;
                    }
                }
            }
        }

        bw.flush();
        bw.close();
    }
}
