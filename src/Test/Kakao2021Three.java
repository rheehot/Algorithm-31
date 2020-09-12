package Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Kakao2021Three {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] info = new String[n];
        for(int i = 0; i < n; i++) {
            info[i] = br.readLine();
        }

        int m = Integer.parseInt(br.readLine());
        String[] query = new String[n];
        for(int i = 0; i < n; i++) {
            query[i] = br.readLine();
        }

        solution(info, query);

        bw.flush();
        bw.close();
    }

    public static int[] solution(String[] info, String[] query) {
        HashMap<String, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < info.length; i++) {
            String temp = info[i].replace(' ', '/');

            int index = 0;
            for(int j = temp.length() - 1; j >= 0; j--) {
                if(temp.charAt(j) == '/') {
                    index = j;
                    break;
                }
            }

            String tStr = temp.substring(0, index);
            int tt = Integer.parseInt(temp.substring(index + 1));
            if(map.containsKey(tStr)) {
                List<Integer> t = map.get(tStr);
                t.add(tt);
                map.put(tStr, t);
            }
            else {
                List<Integer> t = new ArrayList<>();
                t.add(tt);
                map.put(tStr, t);
            }
        }

        int[] answer = new int[query.length];
        for(int i = 0; i < query.length; i++) {
            String[] s = query[i].split(" and ");
            String[] ss = new String[s.length - 1];
            for(int j = 0; j < ss.length; j++) {
                s[j] = ss[j];
            }
            String[] tempNum = s[s.length - 1].split(" ");
            int max = 0;
            if(tempNum[tempNum.length - 1] == "-") {
                max = 0;
            }
            else {
                max = Integer.parseInt(tempNum[tempNum.length - 1]);
            }
            List<String> list = new ArrayList<>();
            String[] q = makeQ(ss, list, 0);
            if(q.length == 0) {
                continue;
            }

            for(int j = 0; j < q.length; j++) {
                List<Integer> temp = map.get(q[j]);

                if(s[s.length - 1].equals("-")) {
                    answer[j] += temp.size();
                    continue;
                }
                int count = 0;
                for(int size = 0; size < temp.size(); size++) {
                    if(temp.get(size) >= max) {
                        count++;
                    }
                }
                answer[j] += count;
            }
        }


        return answer;
    }

    static String[] makeQ(String[] s, List<String> list, int index) {
        if(index >= s.length - 1) {
            String[] answer = list.toArray(new String[list.size()]);
            return answer;
        }

        int size = list.size();
        for(int i = 0; i < size; i++) {
            if(s[index] == "-") {
                switch(index) {
                    case 0:
                        list.add(i, list.get(i) + "/java");
                        list.add(i, list.get(i) + "/cpp");
                        list.add(i, list.get(i) + "/python");
                        break;
                    case 1:
                        list.add(i, list.get(i) + "/backend");
                        list.add(i, list.get(i) + "/frontend");
                        break;
                    case 2:
                        list.add(i, list.get(i) + "/senior");
                        list.add(i, list.get(i) + "/junior");
                        break;
                    case 3:
                        list.add(i, list.get(i) + "/pizza");
                        list.add(i, list.get(i) + "/chiken");
                        break;
                }
            }
            else {
                list.add(i, list.get(i) + "/" + s[index]);
            }
        }
        makeQ(s, list, index + 1);
        return (new String[0]);
    }
}