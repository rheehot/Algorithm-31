package Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Line2020One {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] boxes = {{1, 2}, {2, 1}, {3, 3}, {4, 5}, {5, 6}, {7, 8}};
        bw.write(solution(boxes) + "");

        bw.flush();
        bw.close();
    }

    public static int solution(int[][] boxes) {
        // 맞춰야하는 짝의 수
        int count = boxes.length;
        List<Integer> boxList = new ArrayList<>();
        for(int i = 0; i < boxes.length; i++) {
            // 짝 지어지는 박스가 있음
            if(boxList.contains(boxes[i][0])) {
                count--;
                int index = boxList.indexOf(boxes[i][0]);
                boxList.remove(index);
            }
            else {
                boxList.add(boxes[i][0]);
            }
            if(boxList.contains(boxes[i][1])) {
                count--;
                int index = boxList.indexOf(boxes[i][1]);
                boxList.remove(index);
            }
            else {
                boxList.add(boxes[i][1]);
            }
        }

        // 모든 박스가 짝지어짐
        if(count == 0) {
            return 0;
        }

        if(count <= boxList.size()) {
            return count;
        }

        int answer = boxList.size();
        count -= (answer);
        answer += (count * 2);
        return answer;
    }
}
