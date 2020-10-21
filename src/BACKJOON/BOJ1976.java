package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ1976 {
    static int[] parent;
    static int[] route;
    static int[][] city;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        parent = new int[n + 1];
        route = new int[m];
        city = new int[n + 1][n + 1];
        StringTokenizer st;
        for(int i = 1; i <= n; i++) {
            parent[i] = i;
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            route[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(city[i][j] == 1) {
                    connection(parent, i, j);
                }
            }
        }

        if(check(parent, route)) {
            bw.write("YES");
        }
        else {
            bw.write("NO");
        }

        bw.flush();
        bw.close();
    }

    static int getParent(int[] parent, int a) {
        if(parent[a] == a) {
            return parent[a];
        }
        else {
            return parent[a] = getParent(parent, parent[a]);
        }
    }
    static void connection(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);

        if(a < b) {
            parent[b] = a;
        }
        else {
            parent[a] = b;
        }
    }
    static boolean check(int[] parent, int[] route) {
        for(int i = 0; i < route.length; i++) {
            if(parent[route[0]] != parent[route[i]]) {
                return false;
            }
        }
        return true;
    }
}
