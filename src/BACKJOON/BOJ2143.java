package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ2143 {
    static long t;
    static long[] a;
    static long[] b;
    static HashMap<Long, Integer> map = new HashMap<>();
    static long answer = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        t = Long.parseLong(br.readLine());
        int n = Integer.parseInt(br.readLine());
        a = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            a[i] = Long.parseLong(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        b = new long[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            b[i] = Long.parseLong(st.nextToken());
        }

        choiceA();
        choiceB();
        bw.write(answer + "");

        bw.flush();
        bw.close();
    }

    public static void choiceA() {
        for(int index = 0; index < a.length; index++) {
            long sum = 0;
            for(int diff = 0; diff < a.length - index; diff++) {
                sum += a[index + diff];
                if(map.containsKey(sum)) {
                    map.put(sum, map.get(sum) + 1);
                }
                else {
                    map.put(sum, 1);
                }
            }
        }
    }

    public static void choiceB() {
        for(int index = 0; index < b.length; index++) {
            long sum = 0;
            for(int diff = 0; diff < b.length - index; diff++) {
                sum += b[index + diff];
                if(map.containsKey(t - sum)) {
                    answer += map.get(t - sum);
                }
            }
        }
    }
}
