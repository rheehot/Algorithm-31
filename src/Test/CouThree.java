package Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class CouThree {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.flush();
        bw.close();
    }

    public static int solution(int k, int[] score) {
        HashMap<Integer,Integer> map = new HashMap<>();

        int[] d = new int[score.length];
        List<Integer> delete = new ArrayList<>();

        for(int i = 1; i < score.length; i++) {
            int diff = score[i - 1] - score[i];
            d[i] = diff;
            if(delete.contains(diff)) {
                continue;
            }

            if(map.containsKey(diff)) {
                map.put(diff, map.get(diff) + 1);
                if(map.get(diff) >= k) {
                    delete.add(diff);
                }
            }
            else {
                map.put(diff, 1);
            }
        }

        boolean[] v = new boolean[score.length];
        int answer = score.length;
        for(int i = 1; i < score.length; i++) {
            if(delete.contains(d[i])) {
                if(!v[i - 1]) {
                    answer--;
                    v[i - 1] = true;
                }
                answer--;
                v[i] = true;
            }
        }
        return answer;
    }
}
