package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2146 {
    static int n;
    static int[][] map;

    static int[][] island;
    static int[][] visited;
    static int answer = Integer.MAX_VALUE;

    static int[] dirI = {0, 0, 1, -1};
    static int[] dirJ = {1, -1, 0, 0};

    static Queue<BridgeNode> bridgeQ = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        island = new int[n][n];
        visited = new int[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int index = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] == 1 && island[i][j] == 0) {
                    setIsland(index, i, j);
                    index++;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                // 육지
                if(map[i][j] == 1) {
                    bridgeQ.clear();
                    for(int dirIndex = 0; dirIndex < 4; dirIndex++) {
                        int nextI = i + dirI[dirIndex];
                        int nextJ = j + dirJ[dirIndex];

                        if(nextI < 0 || nextI >= n || nextJ < 0 || nextJ >= n || map[nextI][nextJ] == 1) {
                            continue;
                        }

                        bridgeQ.offer(new BridgeNode(nextI, nextJ, 1));
                        visited[nextI][nextJ] = 1;
                    }
                    if(!bridgeQ.isEmpty()) {
                        make(island[i][j]);
                    }
                }
            }
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
    }
    // 다리 건설
    static void make(int index) {
        while(!bridgeQ.isEmpty()) {
            BridgeNode temp = bridgeQ.poll();

            for(int dirIndex = 0; dirIndex < 4; dirIndex++) {
                int nextI = temp.i + dirI[dirIndex];
                int nextJ = temp.j + dirJ[dirIndex];

                if(nextI < 0 || nextI >= n || nextJ < 0 || nextJ >= n || island[nextI][nextJ] == index || visited[nextI][nextJ] <= temp.count + 1) {
                    continue;
                }

                if(map[nextI][nextJ] == 1) {
                    answer = Math.min(answer, temp.count);
                    continue;
                }

                visited[nextI][nextJ] = temp.count + 1;
                bridgeQ.offer(new BridgeNode(nextI, nextJ, temp.count + 1));
            }
        }
    }
    // 육지 index 정하기
    static void setIsland(int index, int i, int j) {
        island[i][j] = index;
        for(int dirIndex = 0; dirIndex < 4; dirIndex++) {
            int nextI = i + dirI[dirIndex];
            int nextJ = j + dirJ[dirIndex];

            if(nextI < 0 || nextI >= n || nextJ < 0 || nextJ >= n || map[nextI][nextJ] == 0 || island[nextI][nextJ] == index) {
                continue;
            }

            setIsland(index, nextI, nextJ);
        }
    }
}

class BridgeNode {
    int i;
    int j;
    int count;

    BridgeNode(int i, int j, int count) {
        this.i = i;
        this.j = j;
        this.count = count;
    }
}
