package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class JipHap {
    public static boolean[] arr = new boolean[21];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "add":
                    add(Integer.parseInt(st.nextToken()));
                    break;
                case "remove":
                    remove(Integer.parseInt(st.nextToken()));
                    break;
                case "check":
                    boolean r = check(Integer.parseInt(st.nextToken()));
                    if(r) {
                        bw.write(1+"\n");
                    }
                    else {
                        bw.write(0+"\n");
                    }
                    break;
                case "toggle":
                    toggle(Integer.parseInt(st.nextToken()));
                    break;
                case "all":
                    all();
                    break;
                case "empty":
                    empty();
                    break;
            }
        }

        bw.flush();
        bw.close();
    }

    public static void add(int n) {
        arr[n] = true;
    }
    public static void remove(int n){
        arr[n] = false;
    }
    public static boolean check(int n) {
        return arr[n];
    }
    public static void toggle(int n) {
        arr[n] = !arr[n];
    }
    public static void all() {
        for(int i = 1; i <= 20; i++) {
            arr[i] = true;
        }
    }
    public static void empty() {
        for(int i = 1; i <= 20; i++) {
            arr[i] = false;
        }
    }
}
