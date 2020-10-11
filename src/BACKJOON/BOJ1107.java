package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ1107 {
    static String target;
    static int n;
    static boolean[] nums = new boolean[10];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));;

        target = br.readLine();
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            nums[Integer.parseInt(st.nextToken())] = true;
        }

        bw.write(solution() + "");
        bw.flush();
        bw.close();
    }

    public static int solution() {
        if (target.equals("100")) {
            return 0;
        }

        if (n == 0) {
            return Math.min(target.length(), Math.abs(100 - Integer.parseInt(target)));
        }

        
    }

}
