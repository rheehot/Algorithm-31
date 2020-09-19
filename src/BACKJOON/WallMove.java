package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class WallMove {
    static int N, M;
    static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        for(int i = 1; i <= N; i++) {
            String str = br.readLine();
            for(int j = 1; j <= M; j++) {
                map[i][j] = str.charAt(j - 1) - '0';
            }
        }

        int answer = solution();
        bw.write(answer + "");

        bw.flush();
        bw.close();
    }

    static int[] dirI = {0, 0, 1, -1};
    static int[] dirJ = {1, -1, 0, 0};
    public static int solution() {
        Queue<WallNode> q = new LinkedList<>();
        q.add(new WallNode(1, 1));
        boolean[][][] visit = new boolean[N + 1][M + 1][2];
        visit[1][1][0] = true;

        int count = 1;
        while(!q.isEmpty()) {
            int len = q.size();
            for(int i = 0; i < len; i++) {
                WallNode temp = q.poll();
                if(temp.i == N && temp.j == M) {
                    return count;
                }

                for(int index = 0; index < dirI.length; index++) {
                    int nextI = temp.i + dirI[index];
                    int nextJ = temp.j + dirJ[index];

                    if(nextI > N || nextJ > M || nextI == 0 || nextJ == 0) {
                        continue;
                    }

                    WallNode nextNode = new WallNode(nextI, nextJ);

                    // 이미 벽을 부숨
                    if(temp.wall == 1) {
                        if(map[nextI][nextJ] == 1) {
                            continue;
                        }
                        // 이미 방문 했음
                        if(visit[nextI][nextJ][1]) {
                            continue;
                        }

                        visit[nextI][nextJ][1] = true;
                        nextNode.wall = 1;
                        q.add(nextNode);
                    }
                    else {
                        if(map[nextI][nextJ] == 1) {
                            if(visit[nextI][nextJ][1]) {
                                continue;
                            }

                            visit[nextI][nextJ][1] = true;
                            nextNode.wall = 1;
                            q.add(nextNode);
                        }
                        else {
                            if(visit[nextI][nextJ][0]) {
                                continue;
                            }

                            visit[nextI][nextJ][0] = true;
                            nextNode.wall = 0;
                            q.add(nextNode);
                        }
                    }
                }
            }
            count++;
        }

        return -1;
    }

}

class WallNode {
    int i;
    int j;
    int wall;

    WallNode(int i, int j) {
        this.i = i;
        this.j = j;
        this.wall = 0;
    }
}
