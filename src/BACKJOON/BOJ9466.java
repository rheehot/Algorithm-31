package BACKJOON;

import java.util.Scanner;

public class BOJ9466 {
    static int[] arr;
    static boolean[] visit, done;
    static int cnt;

    private static void dfs(int v) {
        if(visit[v]) {
            done[v] = true; cnt++;
        }else visit[v] = true;

        if(!done[arr[v]]) dfs(arr[v]);
        visit[v] = false; done[v] = true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt(), n;

        while(t-- > 0) {
            n = scan.nextInt(); cnt = 0;
            arr = new int[n+1]; visit = new boolean[n+1]; done = new boolean[n+1];

            for(int i = 1; i <= n; i++) arr[i] = scan.nextInt();
            for(int i = 1; i <= n; i++) if(!done[i]) dfs(i);

            System.out.println(n - cnt);
        }
    }
}
