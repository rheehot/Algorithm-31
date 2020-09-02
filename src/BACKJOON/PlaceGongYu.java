package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PlaceGongYu {
    static int N, C;
    static int[] house;
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        house = new int[N];
        for(int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);
        int start = 1;
        int end = house[N - 1] - house[0];
        int middle = 0;

        while(start <= end) {
            middle = (start + end) / 2;
            int count = judge(middle);

            if(count >= C) {
                answer = middle;
                start = middle + 1;
            }
            else {
                end = middle - 1;
            }
        }

        bw.write(answer+"");

        bw.flush();
        bw.close();
    }

    static int judge(int middle) {
        int start = house[0];
        int count = 1;

        for(int i = 1; i < N; i++) {
            int d = house[i] - start;
            if(middle <= d) {
                count++;
                start = house[i];
            }
        }

        return count;
    }
}
