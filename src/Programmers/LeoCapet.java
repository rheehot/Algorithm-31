package Programmers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class LeoCapet {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.flush();
        bw.close();
    }

    public int[] solution(int brown, int yellow) {

        brown -= 4;
        brown /= 2;

        int[] answer = new int[2];
        for(int i = 1; i <= brown / 2; i++) {
            if(i * (brown - i) == yellow) {

                answer[0] = (brown - i) + 2;
                answer[1] = i + 2;

                break;
            }
        }

        return answer;
    }
}
