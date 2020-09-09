package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PartSum {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int answer = 0;
        int sum = 0;
        while(true) {
            if(sum >= S) {
                if(answer == 0) {
                    answer = end - start;
                }
                else {
                    answer = Math.min(answer, end - start);
                }
                sum = sum - nums[start++];
            }
            else if(end == N) {
                break;
            }
            else {
                sum = sum + nums[end++];
            }
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
    }
}
