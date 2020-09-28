package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ5427 {
    static int w, h;
    static int[][] map;
    static Queue<FireNode> fires = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new int[h][w];

            fires.clear();

            FireNode cur = null;
            for(int i = 0; i < h; i++) {
                String temp = br.readLine();
                for(int j = 0; j < w; j++) {
                    char tt = temp.charAt(j);
                    if(tt == '#') {
                        map[i][j] = 1;
                        continue;
                    }
                    if(tt == '@') {
                        cur = new FireNode(i, j);
                        continue;
                    }
                    if(tt == '*') {
                        map[i][j] = -1;
                        fires.offer(new FireNode(i, j));
                    }
                }
            }

            int answer = move(cur);
            if(answer < 0) {
                bw.write("IMPOSSIBLE\n");
            }
            else {
                bw.write(answer + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
    
    static boolean[][] visit;
    static int[] dirI = {0, 0, 1, -1};
    static int[] dirJ = {1, -1, 0, 0};

    static int move(FireNode cur) {
        visit = new boolean[h][w];
        Queue<FireNode> sangQ = new LinkedList<>();
        sangQ.offer(cur);
        visit[cur.i][cur.j] = true;

        int second = 0;

        // 상근이 이동
        while(!sangQ.isEmpty()) {
            // 불 이동
            int fireSize = fires.size();
            for(int i = 0; i < fireSize; i++) {
                FireNode temp = fires.poll();
                for(int index = 0; index < 4; index++) {
                    int nextI = temp.i + dirI[index];
                    int nextJ = temp.j + dirJ[index];

                    if(nextI < 0 || nextI >= h || nextJ < 0 || nextJ >= w || map[nextI][nextJ] == 1 || map[nextI][nextJ] == -1) {
                        continue;
                    }

                    map[nextI][nextJ] = -1;
                    fires.offer(new FireNode(nextI, nextJ));
                }
            }

            int sangSize = sangQ.size();
            for(int i = 0; i < sangSize; i++) {
                FireNode tempSang = sangQ.poll();
                for(int index = 0; index < 4; index++) {
                    int nextI = tempSang.i + dirI[index];
                    int nextJ = tempSang.j + dirJ[index];

                    if(nextI < 0 || nextI >= h || nextJ < 0 || nextJ >= w) {
                        return second + 1;
                    }
                    if(map[nextI][nextJ] == 1 || map[nextI][nextJ] == -1 || visit[nextI][nextJ]) {
                        continue;
                    }

                    visit[nextI][nextJ] = true;
                    sangQ.offer(new FireNode(nextI, nextJ));
                }
            }
            second++;
        }
        return -1;
    }
}

class FireNode {
    int i;
    int j;

    FireNode(int i, int j) {
        this.i = i;
        this.j = j;
    }
}