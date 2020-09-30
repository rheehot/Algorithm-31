package Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class StreetOne {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] one = {1, 2, 1};
        int[] two = {2, 1, 4, 4};
        int[] three = {6, 2, 3, 5, 6, 3};

        bw.write(solution(one) + "\n");
        bw.write(solution(two) + "\n");
        bw.write(solution(three) + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int[] A) {
        Arrays.sort(A);
        int answer = 0;

        for(int i = 0; i < A.length; i++) {
            if(A[i] == i + 1) {
                continue;
            }
            answer += Math.abs(A[i] - (i + 1));
        }

        return answer;
    }
}
