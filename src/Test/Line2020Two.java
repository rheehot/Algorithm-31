package Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Line2020Two {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] ball = {11, 2, 9, 13, 24};
        int[] order = {9, 2, 13, 24, 11};

        int[] answer = solution(ball, order);
        for(int i = 0; i < answer.length; i++) {
            bw.write(answer[i] +"\n");
        }

        bw.flush();
        bw.close();
    }

    public static int[] solution(int[] ball, int[] order) {

        int[] answer = new int[ball.length];

        List<Integer> orderList = new ArrayList<>();
        int start = 0;
        int end = ball.length - 1;

        int answerIndex = 0;
        int orderIndex = 0;
        while(start <= end) {
            // 빼야하는 공 번호
            int ballNum = order[orderIndex];

            // 선행 번호 있는지 확인
            if(orderList.contains(ball[start])) {
                int index = orderList.indexOf(ball[start]);
                orderList.remove(index);
                answer[answerIndex++] = ball[start++];
                continue;
            }
            if(orderList.contains(ball[end])) {
                int index = orderList.indexOf(ball[end]);
                orderList.remove(index);
                answer[answerIndex++] = ball[end--];
                continue;
            }

            // 뒤에서 빼기
            if(ball[start] == ballNum) {
                answer[answerIndex++] = ball[start++];
                orderIndex++;
                continue;
            }
            // 앞에서 빼기
            if(ball[end] == ballNum) {
                answer[answerIndex++] = ball[end--];
                orderIndex++;
                continue;
            }

            orderList.add(ballNum);
            orderIndex++;
        }

        return answer;
    }
}
