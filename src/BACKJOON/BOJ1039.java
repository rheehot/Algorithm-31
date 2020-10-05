package BACKJOON;

import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1039 {
    static int k;
    static String o;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        o = st.nextToken();
        int origin = Integer.parseInt(o);
        k = Integer.parseInt(st.nextToken());

        bw.write(solution(origin) + "");
        bw.flush();
        bw.close();
    }

    public static int solution(int origin) {
        boolean[][] visit = new boolean[1000001][k + 1];
        Queue<GyoNode> q = new LinkedList<>();
        q.offer(new GyoNode(origin, 0));
        visit[origin][0] = true;

        while(!q.isEmpty()) {
            if(q.peek().count == k) {
                break;
            }

            GyoNode temp = q.poll();
            for(int i = 0; i < o.length() - 1; i++) {
                for (int j = i + 1; j < o.length(); j++) {
                    int c = change(temp.num, i, j);
                    if (c != -1 && !visit[c][temp.count + 1]) {
                        visit[c][temp.count + 1] = true;
                        q.offer(new GyoNode(c, temp.count + 1));
                    }
                }
            }
        }

        int result = -1;

        while(!q.isEmpty()) {
            GyoNode po = q.poll();
            if(result < po.num)
                result = po.num;
        }

        return result;
    }

    public static int change(int origin, int i, int j) {
        String originStr = origin + "";
        if(originStr.charAt(j) == '0' && i == 0) {
            return -1;
        }

        String result = originStr.substring(0, i);
        result += originStr.charAt(j);
        result += originStr.substring(i + 1, j);
        result += originStr.charAt(i);
        result += originStr.substring(j + 1);

        return Integer.parseInt(result);
    }
}

class GyoNode {
    int num;
    int count;

    GyoNode(int num, int count) {
        this.num = num;
        this.count = count;
    }
}
