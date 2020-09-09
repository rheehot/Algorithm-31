package Programmers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class KaKao2018Dart {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String dartResult = br.readLine();
        bw.write(solution(dartResult) + "");

        bw.flush();
        bw.close();
    }

    public static int solution(String dartResult) {

        String temp = "";

        List<Integer> list = new ArrayList<>();
        int index = 0;
        while(index < dartResult.length()) {
            char t = dartResult.charAt(index);
            if(t == '*' || t == '#') {
                switch(t) {
                    case '*':
                        if(list.size() == 1) {
                            list.add(list.remove(0) * 2);
                        }
                        else {
                            int one = list.remove(list.size() - 1);
                            int two = list.remove(list.size() - 1);

                            list.add(two * 2);
                            list.add(one * 2);
                        }
                        break;
                    case '#':
                        list.add(list.remove(list.size() - 1) * -1);
                        break;
                }
                index++;
                continue;
            }
            if(t == 'S' || t == 'D' || t == 'T') {
                int tt = Integer.parseInt(temp);
                temp = "";
                switch (t) {
                    case 'D':
                        tt = (int) Math.pow(tt, 2);
                        break;
                    case 'T':
                        tt = (int) Math.pow(tt, 3);
                        break;
                }
                list.add(tt);
            }
            else {
                temp += t;
            }
            index++;
        }

        int answer = 0;
        int size = list.size();
        for(int i = 0; i < size; i++) {
            answer += list.get(i);
        }
        return answer;
    }

}
