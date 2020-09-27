package Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class NaverTwo {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] oneBlocks = {{0, 50}, {0, 22}, {2, 10}, {1,4}, {4, -13}};
        int[] oneAnswer = solution(oneBlocks);
        for(int i = 0; i < oneAnswer.length; i++) {
            bw.write(oneAnswer[i] + " ");
        }
        bw.write("\n");

        int[][] twoBlocks = {{0, 92}, {1, 20}, {2, 11}, {1, -81}, {3, 98}};
        int[] twoAnswer = solution(twoBlocks);
        for(int i = 0; i < twoAnswer.length; i++) {
            bw.write(twoAnswer[i] + " ");
        }

        bw.flush();
        bw.close();
    }

    static int[][] primid;
    static boolean[][] visit;
    public static int[] solution(int[][] blocks) {
        int floor = blocks.length;
        primid = new int[floor][floor];
        visit = new boolean[floor][floor];

        for(int i = 0; i < floor; i++) {
            int diff = blocks[i][0];
            int nums = blocks[i][1];

            primid[i][diff] = nums;
            visit[i][diff] = true;
        }

        for(int i = 1; i < floor; i++) {
            for(int j = 0; j <= i; j++) {
                // 숫자가 있는 곳
                if(visit[i][j]) {
                    fill(i, j);
                }
            }
        }

        List<Integer> answerList = new ArrayList<>();
        for(int i = 0; i < floor; i++) {
            for(int j = 0; j <= i; j++) {
                answerList.add(primid[i][j]);
            }
        }

        int[] answer = new int[answerList.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    public static void fill(int i, int j) {
        // 왼쪽 채우기
        int curJ = j;
        while(curJ >= 1) {
            primid[i][curJ - 1] = primid[i - 1][curJ - 1] - primid[i][curJ];
            visit[i][curJ - 1] = true;
            curJ--;
        }

        // 오른쪽 채우기
        curJ = j;
        while(curJ < i) {
            primid[i][curJ + 1] = primid[i - 1][curJ] - primid[i][curJ];
            visit[i][curJ + 1] = true;
            curJ++;
        }
    }
}
