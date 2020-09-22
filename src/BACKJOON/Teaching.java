package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Teaching {
    static int N, K;

    static List<Character> list = new LinkedList<>();
    static Queue<String> q = new LinkedList<>();
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            q.offer(str);
            for(int index = 4; index < str.length() - 4; index++) {
                char temp = str.charAt(index);
                if(temp == 'a' || temp == 't' || temp == 'i' || temp == 'c' || temp == 'n') {
                    continue;
                }

                if(!list.contains(temp)) {
                    list.add(temp);
                }
            }
        }

        if(list.size() <= K - 5) {
            bw.write(q.size() + "");
        }
        else {
            boolean[] listIndex = new boolean[list.size()];
            check(listIndex, 0, 0);
            bw.write(answer + "");
        }

        bw.flush();
        bw.close();
    }

    public static void check(boolean[] listIndex, int index, int count) {
        if(index >= listIndex.length) {
            if(count == K - 5) {
                List<Character> l = new LinkedList<>();
                for(int i = 0; i < listIndex.length; i++) {
                    if(listIndex[i]) {
                        l.add(list.get(i));
                    }
                }

                int c = possible(l);
                if(answer < c) {
                    answer = c;
                }
            }
            return;
        }

        listIndex[index] = true;
        check(listIndex, index + 1, count + 1);
        listIndex[index] = false;
        check(listIndex, index + 1, count);
    }

    public static int possible(List<Character> l) {
        int count = 0;
        int size = q.size();
        for(int i = 0; i < size; i++) {
            String temp = q.poll();
            boolean flag = true;
            for(int j = 0; j < temp.length(); j++) {
                char t = temp.charAt(j);
                if(t == 'a' || t == 't' || t == 'i' || t == 'c' || t == 'n') {
                    continue;
                }

                if(!l.contains(t)) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                count++;
            }
            q.offer(temp);
        }
        return count;
    }
}
