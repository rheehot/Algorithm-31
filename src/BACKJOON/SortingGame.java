package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SortingGame {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        String str = "";
        String target = "";
        for(int i = 1; i <= N; i++) {
            target += i;
            str += st.nextToken();
        }

        if(target.equals(str)) {
            bw.write("0");
        }
        else {
            HashSet<String> set = new HashSet<>();
            set.add(str);

            Queue<String> q = new LinkedList<>();
            q.add(str);
            int count = 0;
            boolean flag = false;
            while(!q.isEmpty()) {
                int len = q.size();
                for(int s = 0; s < len; s++) {
                    String temp = q.poll();
                    // 똑같음
                    if(temp.equals(target)) {
                        flag = true;
                        bw.write(count+"");
                        break;
                    }

                    for(int i = 0; i <= temp.length() - K; i++) {
                        String next = temp.substring(0, i);
                        next += new StringBuilder(temp.substring(i, i + K)).reverse().toString();
                        next += temp.substring(i + K);

                        if(!set.contains(next)) {
                            set.add(next);
                            q.offer(next);
                        }
                    }
                }
                count++;
            }

            if(!flag) {
                bw.write("-1");
            }
        }

        bw.flush();
        bw.close();
    }
}
