package Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Line2020Three {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] answer = solution(9);
        bw.write(answer[0] +"\n");
        bw.write(answer[1] +"\n");

        bw.flush();
        bw.close();
    }

    public static int[] solution(int n) {
        int[] answer = new int[2];

        // 한자리 수
        if(n < 10) {
            answer[0] = 0;
            answer[1] = n;

            return answer;
        }

        Queue<String> q = new LinkedList<>();
        String temp = "";
        temp += n;
        q.offer(temp);

        int count = 0;
        while(!q.isEmpty()) {
            int len = q.size();
            boolean flag = false;

            for(int i = 0; i < len; i++) {
                temp = q.poll();
                if(temp.length() == 1) {
                    if(temp.length() == 1) {
                        answer[0] = count;
                        answer[1] = Integer.parseInt(temp);
                        flag = true;
                        break;
                    }
                }

                for(int index = 1; index < temp.length(); index++) {
                    String front = temp.substring(0, index);
                    String back = temp.substring(index);

                    if(back.charAt(0) == '0') {
                        continue;
                    }

                    q.offer(cal(Integer.parseInt(front), Integer.parseInt(back)));
                }
            }

            if(flag) {
                break;
            }
            count++;
        }

        return answer;
    }

    public static String cal(int a, int b) {
        int answer = a + b;
        String str = "";
        str += answer;
        return str;
    }
}
