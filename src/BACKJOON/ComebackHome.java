package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ComebackHome {
    static int R, C, K;
    static char[][] map;

    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        char diff = 'a';
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                if (str.charAt(j) == 'T') {
                    map[i][j] = 'T';
                    continue;
                }
                map[i][j] = diff;
                diff += 1;
            }
        }

        solution(R - 1, 0, map[R - 1][0] + "");
        bw.write(list.size()+"");
        bw.flush();
        bw.close();
    }

    static int[] dirI = {0, 0, 1, -1};
    static int[] dirJ = {1, -1, 0, 0};

    public static void solution(int i, int j, String result) {
        if(result.length() >= K) {
            if(result.length() == K && result.charAt(result.length() - 1) == map[0][C - 1]) {
                if(!list.contains(result)) {
                    list.add(result);
                }
            }
            return;
        }

        for(int index = 0; index < 4; index++) {
            int nextI = i + dirI[index];
            int nextJ = j + dirJ[index];

            if(nextI < 0 || nextI >= R || nextJ < 0 || nextJ >= C || map[nextI][nextJ] == 'T' || result.contains(map[nextI][nextJ]+"")) {
                continue;
            }

            solution(nextI, nextJ, result + map[nextI][nextJ]);
        }
    }
}