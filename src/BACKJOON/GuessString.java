package BACKJOON;

import java.io.*;
import java.util.HashSet;

public class GuessString {
    static int N;
    static String[] strs;
    static String[] origin = new String[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        strs = new String[2 * N - 2];

        String pre = null, post = null;

        for(int i = 0; i < strs.length; i++) {
            strs[i] = br.readLine();

            if(strs[i].length() == N - 1) {
                if(pre == null) {
                    pre = strs[i];
                }
                else {
                    post = strs[i];
                }
            }
        }

        origin[0] = pre + post.charAt(post.length() - 1);
        origin[1] = post + pre.charAt(pre.length() - 1);

        HashSet<String> set = new HashSet<>();
        for(String ori : origin) {
            set.clear();
            StringBuilder sb = new StringBuilder();

            for(String s : strs) {
                if(ori.indexOf(s) == 0) {
                    if(!set.contains(s)) {
                        set.add(s);
                        sb.append("P");
                    }
                    else {
                        sb.append("S");
                    }
                }
                else {
                    if(s.charAt(s.length() - 1) == ori.charAt(ori.length() - 1)) {
                        sb.append("S");
                    }
                }
            }

            if(sb.length() == 2 * N - 2) {
                bw.write(ori + "\n");
                bw.write(sb.toString());
                break;
            }
        }

        bw.flush();
        bw.close();
    }
}
