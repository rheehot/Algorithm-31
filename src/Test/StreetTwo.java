package Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class StreetTwo {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] one = {"abc", "bca", "dbe"};
        String[] two = {"zzzz", "ferz", "zdsr", "fgtd"};
        String[] three = {"gr", "sd", "rg"};
        String[] four = {"bdafg", "ceagi"};

        int[] oneAnswer = solution(one);
        int[] twoAnswer = solution(two);
        int[] threeAnswer = solution(three);
        int[] fourAnswer = solution(four);

        bw.write(oneAnswer[0] + " " + oneAnswer[1] + " " + oneAnswer[2] + "\n");
        bw.write(twoAnswer[0] + " " + twoAnswer[1] + " " + twoAnswer[2] + "\n");
        if(threeAnswer.length == 0) {
            bw.write("null\n");
        }
        bw.write(fourAnswer[0] + " " + fourAnswer[1] + " " + fourAnswer[2] + "\n");

        bw.flush();
        bw.close();
    }

    public static int[] solution(String[] S) {
        List<Integer> list = new ArrayList<>();

        int len = S[0].length();
        boolean flag = false;
        for(int row = 0; row < S.length - 1; row++) {
            for(int next = row + 1; next < S.length; next++) {
                for(int index = 0; index < len; index++) {
                    if(S[row].charAt(index) == S[next].charAt(index)) {
                        list.add(row);
                        list.add(next);
                        list.add(index);
                        flag = true;
                        break;
                    }
                }
                if(flag) {
                    break;
                }
            }
            if(flag) {
                 break;
            }
        }

        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
