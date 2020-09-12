package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class LeeDaSom {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, String> map = new HashMap<>();
        for(int i = 1; i <= N; i++) {
            String po = br.readLine();
            String index = i + "";
            map.put(index, po);
            map.put(po, index);
        }

        for(int i = 0; i < M; i++) {
            bw.write(map.get(br.readLine()) + "\n");
        }

        bw.flush();
        bw.close();
    }
}
