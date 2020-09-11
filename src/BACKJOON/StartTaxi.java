package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class StartTaxi {
    static int N, M;
    static int[][] map;
    static StartTaxiNode taxi;
    static int[][] pMap;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int battery = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        pMap = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        taxi = new StartTaxiNode(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        taxi.battery = battery;

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            pMap[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = -1 * (i + 1);
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = -1 * (i + 1);
        }

        bw.flush();
        bw.close();
    }

    static int[] dirI = {0, 0, 1, -1};
    static int[] dirJ = {1, -1, 0, 0};

    public static void findPassenger() {
        Queue<StartTaxiNode> q = new LinkedList<>();
        q.offer(taxi);

        boolean flag = false;
        while(!q.isEmpty()) {
            int size = q.size();

            int indexI = Integer.MAX_VALUE;
            int indexJ = Integer.MAX_VALUE;
            for(int i = 0; i < size; i++) {
                StartTaxiNode temp = q.poll();

                // 승객이 있음
                if(pMap[temp.i][temp.j] != 0) {
                    flag = true;
                    if(temp.i < indexI) {
                        indexI = temp.i;
                    }
                    else if(temp.i == indexI) {
                        if(temp.j < indexJ) {
                            indexJ = temp.j;
                        }
                    }
                    continue;
                }

                for(int index = 0; index < 4; index++) {
                    int tempI = temp.i + dirI[index];
                    int tempJ = temp.j + dirJ[index];

                    if(tempI < 0 || tempI >= N || tempJ < 0 || tempJ >= N || map[tempI][tempJ] == 1) {
                        continue;
                    }

                    q.offer(new StartTaxiNode(tempI, tempJ));
                }
            }
            if(flag) {
                break;
            }

            taxi.battery--;
        }
    }
}

class StartTaxiNode {
    int i;
    int j;

    int battery;

    StartTaxiNode(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
