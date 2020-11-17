package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ3078 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] lengthArr = new int[k];
        Queue<Integer> lengthQ = new LinkedList<>();

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < k; i++) {
            lengthArr[i] = br.readLine().length();

            if (i == 0) {
                continue;
            }

            if(i <= n) {
                if(map.containsKey(lengthArr[i])) {
                    map.put(lengthArr[i], map.get(lengthArr[i]) + 1);
                }
                else {
                    map.put(lengthArr[i], 1);
                }
                continue;
            }

            lengthQ.offer(lengthArr[i]);
        }

        long answer = 0;
        for(int index = 0; index < k; index++) {
            if(index == 0) {
                if(map.containsKey(lengthArr[index])) {
                    answer += map.get(lengthArr[index]);
                }
                continue;
            }

            if(map.containsKey(lengthArr[index])) {
                if(map.get(lengthArr[index]) == 1) {
                    map.remove(lengthArr[index]);
                }
                else {
                    map.put(lengthArr[index], map.get(lengthArr[index]) - 1);
                }
            }
            if(!lengthQ.isEmpty()) {
                int next = lengthQ.poll();
                if(map.containsKey(next)) {
                    map.put(next, map.get(next) + 1);
                }
                else {
                    map.put(next, 1);
                }
            }

            if(map.containsKey(lengthArr[index])) {
                answer += map.get(lengthArr[index]);
            }
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
    }
}