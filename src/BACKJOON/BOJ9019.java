package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ9019 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int test = 0; test < t; test++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            bw.write(solution(start, end) + "\n");
        }

        bw.flush();
        bw.close();
    }
    public static String solution(int start, int end) {
        Queue<DSLRNode> q = new LinkedList<>();
        q.offer(new DSLRNode(start, ""));

        boolean[] visited = new boolean[10001];
        visited[start] = true;

        while(!q.isEmpty()) {
            DSLRNode temp = q.poll();
            if(temp.str == end) {
                return temp.order;
            }

            int D = D(temp.str);
            if(!visited[D]) {
                q.offer(new DSLRNode(D, temp.order + "D"));
                visited[D] = true;
            }
            int S = S(temp.str);
            if(!visited[S]) {
                q.offer(new DSLRNode(S, temp.order + "S"));
                visited[S] = true;
            }
            int L = L(temp.str);
            if(!visited[L]) {
                q.offer(new DSLRNode(L, temp.order + "L"));
                visited[L] = true;
            }
            int R = R(temp.str);
            if(!visited[R]) {
                q.offer(new DSLRNode(R, temp.order + "R"));
                visited[R] = true;
            }
        }

        return "";
    }

    public static int D(int origin) {
        origin *= 2;
        origin %= 10000;
        return origin;
    }

    public static int S(int origin) {
        origin--;
        if(origin < 0) {
            return 9999;
        }
        return origin;
    }

    public static int L(int origin) {
        int result = origin % 1000;
        result *= 10;
        result += (origin / 1000);
        return result;
    }

    public static int R(int origin) {
        int result = origin % 10;
        result *= 1000;
        result += (origin / 10);
        return result;
    }
}

class DSLRNode {
    int str;
    String order;

    DSLRNode(int str, String order) {
        this.str = str;
        this.order = order;
    }
}