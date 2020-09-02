package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class NumberCard2 {
    public static int N;
    public static int M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<Integer, Integer> map = new HashMap<>();
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = st.countTokens();
        for(int i = 0; i < size; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            }
            else {
                map.put(num, 1);
            }
        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (map.containsKey(num)) {
                bw.write(map.get(num) + " ");
            }
            else {
                bw.write(0 + " ");
            }
        }
        bw.flush();
        bw.close();
    }
}
