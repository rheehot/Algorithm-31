package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class BOJ1644 {
    static int n;
    static boolean[] sosu;
    static int answer = 0;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        sosu = new boolean[n + 1];

        judge();
        check();

        bw.write(answer + "");

        bw.flush();
        bw.close();
    }

    // 소수인가?
    public static void judge() {
        sosu[0] = sosu[1] = false;

        for(int i = 2; i <= n; i++) {
            sosu[i] = true;
        }

        for(int i = 2; i*i <= n; i++) {
            for(int j = i*i; j <= n; j += i) {
                sosu[j] = false;
            }
        }

        for(int i = 2; i <= n; i++) {
            if(sosu[i]) {
                list.add(i);
            }
        }
    }
    public static void check() {
        int start = 0;
        int end = 0;
        int sum = 0;
        while (true) {
            if (sum >= n) {
                sum = sum - list.get(start++);
            } else if (end == list.size()) {
                break;
            } else {
                sum = sum + list.get(end++);
            }

            if (sum == n) {
                answer++;
            }
        }
    }
}
