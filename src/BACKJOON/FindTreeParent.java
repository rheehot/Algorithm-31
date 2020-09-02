package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class FindTreeParent {
    static int[] answer;
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] visit;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        answer = new int[N + 1];
        visit = new boolean[N + 1];
        list = new ArrayList<ArrayList<Integer>>();
        int[] parents = new int[N + 1];
        for(int i = 0; i <= N; i++) {
            list.add(i, new ArrayList<Integer>());
        }

        for(int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        for(int i = 1; i <= N; i++) {
            if (visit[i]) {
                continue;
            }

            dfs(i);
        }

        for(int i = 2; i <= N; i++) {
            bw.write(answer[i]+ "\n");
        }

        bw.flush();
        bw.close();

    }

    static void dfs(int start) {
        if(visit[start]) {
                return;
        }

        visit[start] = true;
        ArrayList<Integer> temp = list.get(start);

        for(int i = 0; i < temp.size(); i++) {
            if(!visit[temp.get(i)]) {
                answer[temp.get(i)] = start;
                dfs(temp.get(i));
            }
        }
    }
}