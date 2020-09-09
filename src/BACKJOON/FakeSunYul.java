package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FakeSunYul {
    static String str;
    static String answer = "";
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        str = br.readLine();

        // 한자리 수
        if(str.length() <= 9) {
            for(int i = 0; i < str.length(); i++) {
                bw.write(str.charAt(i) + " ");
            }
        }
        else {
            int size = (str.length() - 9) / 2 + 9;

            boolean[] visit = new boolean[size + 1];
            dfs(visit, 0, "");
            bw.write(answer);
        }

        bw.flush();
        bw.close();
    }

    public static void dfs(boolean[] visit, int index, String r) {
        // 끝까지 함
        if(index >= str.length()) {
            answer = r;
            return;
        }

        // 한자리라면
        if(!visit[str.charAt(index) - '0']) {
            int temp = str.charAt(index) - '0';
            if(temp != 0) {
                visit[temp] = true;
                dfs(visit, index + 1, r + " " + str.charAt(index));
                visit[temp] = false;
            }
        }

        // 두자리라면
        if(index + 1 < str.length()) {
            int temp = Integer.parseInt(str.substring(index, index + 2));
            if(temp >= visit.length) {
                return;
            }
            if(!visit[temp]) {
                visit[temp] = true;
                dfs(visit, index + 2, r + " " + temp);
                visit[temp] = false;
            }
        }
    }
}
