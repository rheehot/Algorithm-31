package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CircularQueue {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
            list.add(i);
        }

        st = new StringTokenizer(br.readLine());
        int answer = 0;
        for(int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());

            boolean flag = true;
            while(flag) {
                if(list.get(0) == target) {
                    list.remove(0);
                    flag = false;
                }
                else {
                    if(list.indexOf(target) <= list.size() / 2) {
                        list.add(list.size() - 1, list.remove(0));
                    }
                    else {
                        list.add(0, list.remove(list.size() - 1));
                    }
                    answer++;
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }
}
