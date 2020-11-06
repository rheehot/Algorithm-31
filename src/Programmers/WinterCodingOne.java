package Programmers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class WinterCodingOne {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.flush();
        bw.close();
    }

    public static String solution(int n, int[][] delivery) {
        // 배송 가능건부터 앞에 배치
        Arrays.sort(delivery, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[2] - o1[2];
            }
        });
        int[] answerArr = new int[n];
        for(int i = 0; i < delivery.length; i++) {
            int first  = delivery[i][0] - 1;
            int second = delivery[i][1] - 1;
            // 배송 가능
            if(delivery[i][2] == 1) {
                answerArr[first] = 1;
                answerArr[second] = 1;
                continue;
            }
            // 배송 불가능 -> 근데 무엇때문에 불가능인지를 모름
            if(answerArr[first] == 1) {
                answerArr[second] = 2;
            }
            else if(answerArr[second] == 1) {
                answerArr[first] = 2;
            }
        }

        String answer = "";
        for(int i = 0; i < n; i++) {
            if(answerArr[i] == 1) {
                answer += "O";
            }
            else if(answerArr[i] == 2) {
                answer += "X";
            }
            else {
                answer += "?";
            }
        }

        return answer;
    }
}
