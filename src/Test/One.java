package Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class One {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] one = {"RECEIVE abcd@naver.com", "RECEIVE zzkn@naver.com", "DELETE", "RECEIVE qwerty@naver.com", "SAVE", "RECEIVE QwerTY@naver.com"};
        String[] two = {"RECEIVE abcd@naver.com", "RECEIVE zzkn@naver.com", "DELETE", "RECEIVE qwerty@naver.com", "SAVE", "SAVE", "DELETE", "RECEIVE QwerTY@naver.com", "SAVE"};

        bw.write(solution(one) + "\n");
        bw.write(solution(two));
        bw.flush();
        bw.close();
    }

    public static String solution(String[] record) {
        String answer = "";
        Deque<String> tempSaver = new LinkedList<>();
        for(int i = 0; i < record.length; i++) {
            String[] strs = record[i].split(" ");

            String order = strs[0];

            switch (order) {
                case "RECEIVE":
                    tempSaver.offerLast(strs[1]);
                    break;
                case "DELETE":
                    tempSaver.pollLast();
                    break;
                case "SAVE":
                    while(!tempSaver.isEmpty()) {
                        answer += (" " + tempSaver.pollFirst());
                    }
                    break;
            }
        }
        return answer;
    }
}
