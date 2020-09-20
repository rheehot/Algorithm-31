package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class GreenZelda {
    static int N;
    static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        int T = 1;
        while(true) {
            N = Integer.parseInt(br.readLine());
            if(N == 0) {
                break;
            }

            map = new int[N][N];

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            bw.write("Problem " + T + ": " + solution() + "\n");

            T++;
        }

        bw.flush();
        bw.close();
    }

    static int[] dirI = {0, 0, 1, -1};
    static int[] dirJ = {1, -1, 0, 0};
    static int INF = 100_000_000;

    static int solution() {
        Queue<ZeldaNode> q = new LinkedList<>();
        q.add(new ZeldaNode(0, 0));

        int[][] lupy = new int[N][N];
        for(int i = 0; i < N; i++) {
            Arrays.fill(lupy[i], INF);
        }
        lupy[0][0] = map[0][0];

        while(!q.isEmpty()) {
            ZeldaNode curNode = q.poll();

            for(int index = 0; index < 4; index++) {
                int nextI = curNode.i + dirI[index];
                int nextJ = curNode.j + dirJ[index];

                if(nextI < 0 || nextI >= N || nextJ < 0 || nextJ >= N) {
                    continue;
                }

                if(lupy[nextI][nextJ] > lupy[curNode.i][curNode.j] + map[nextI][nextJ]) {
                    lupy[nextI][nextJ] = lupy[curNode.i][curNode.j] + map[nextI][nextJ];
                    q.add(new ZeldaNode(nextI, nextJ));
                }
            }
        }

        return lupy[N - 1][N - 1];
    }
}

class ZeldaNode {
    int i;
    int j;

    ZeldaNode(int i, int j) {
        this.i = i;
        this.j = j;
    }
}