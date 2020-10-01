package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2470 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long[] nums = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            nums[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(nums);

        int startIndex = 0;
        int endIndex = n - 1;

        long start = nums[0];
        long end = nums[n - 1];

        long max = Long.MAX_VALUE;

        while(startIndex < endIndex) {
            long sum = nums[startIndex] + nums[endIndex];

            if(Math.abs(sum) < max) {
                max = Math.abs(sum);
                start = nums[startIndex];
                end = nums[endIndex];
            }

            if(sum > 0) {
                endIndex--;
            }
            else {
                startIndex++;
            }
        }

        bw.write(start + " " + end);
        bw.flush();
        bw.close();
    }
}
