package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ11559 {
    static char[][] map = new char[12][6];
    static boolean[][] visit = new boolean[12][6];
    static Queue<Puyo> q = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 0; i < 12; i++) {
            String temp = br.readLine();
            for(int j = 0; j < 6; j++) {
                map[i][j] = temp.charAt(j);
            }
        }

        int count = 0;
        while(true) {
            if(check()) {
                count++;
            }
            else {
                break;
            }
            down();
        }

        bw.write(count + "");
        bw.flush();
        bw.close();
    }

    public static boolean check() {
        for(int i = 0; i < 12; i++) {
            Arrays.fill(visit[i], false);
        }

        boolean flag = false;
        for(int i = 0; i < 12; i++) {
            for(int j = 0; j < 6; j++) {
                if(map[i][j] == '.' || visit[i][j]) {
                    continue;
                }

                q.clear();
                dfs(i, j, map[i][j]);
                if(q.size() >= 4) {
                    flag = true;
                    del();
                }
            }
        }
        return flag;
    }

    static int[] dirI = {0, 0, 1, -1};
    static int[] dirJ = {1, -1, 0, 0};
    public static void dfs(int i, int j, char target) {
        q.offer(new Puyo(i, j));
        visit[i][j] = true;

        for(int index = 0; index < 4; index++) {
            int nextI = i + dirI[index];
            int nextJ = j + dirJ[index];

            if(nextI < 0 || nextI >= 12 || nextJ < 0 || nextJ >= 6) {
                continue;
            }

            if(!visit[nextI][nextJ] && target == map[nextI][nextJ]) {
                dfs(nextI, nextJ, target);
            }
        }
    }

    public static void del() {
        while(!q.isEmpty()) {
            Puyo temp = q.poll();
            map[temp.i][temp.j] = '.';
        }
    }

    public static void down() {
        for(int c = 0 ; c < 6 ; ++c) {
            for(int sr = 11 ; sr >= 0 ; --sr) {
                if(map[sr][c] == '.') {
                    for(int nr = sr - 1 ; nr >= 0 ; --nr) {
                        if(map[nr][c] != '.') {
                            map[sr][c] = map[nr][c];
                            map[nr][c] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }
}
class Puyo {
    int i;
    int j;

    Puyo(int i, int j){
        this.i = i;
        this.j = j;
    }
}
