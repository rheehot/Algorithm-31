package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 16:00 -
public class StartTaxi {
    static int N, M, b;
    static int[][] map;
    static int[][] passenger;
    static TaxiNode taxi;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        passenger = new int[N + 1][N + 1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        taxi = new TaxiNode(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), b);
        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int pI = Integer.parseInt(st.nextToken());
            int pJ = Integer.parseInt(st.nextToken());

            int targetI = Integer.parseInt(st.nextToken());
            int targetJ = Integer.parseInt(st.nextToken());

            // 이미 누군가의 목적지
            if(map[targetI][targetJ] < 0) {
                passenger[pI][pJ] = map[targetI][targetJ];
            }
            else {
                passenger[pI][pJ] = -1 * i;
                map[targetI][targetJ] = -1 * i;
            }
        }

        for(int count = 1; count <= M; count++) {
            // 승객 찾았음
            if(findPassenger()) {
                int target = passenger[taxi.i][taxi.j];
                passenger[taxi.i][taxi.j] = 0;

                int useB = move(target);

                if(useB < 0) {
                     taxi.b = -1;
                     break;
                }
                else {
                    taxi.b -= useB;
                    taxi.b += (2 * useB);
                }
            }
            // 불가
            else {
                taxi.b = -1;
                break;
            }
        }

        bw.write(taxi.b + "\n");
        bw.flush();
        bw.close();
    }

    static int[] dirI = {0, 0, 1, -1};
    static int[] dirJ = {1, -1, 0, 0};

    // 종료 -> return false -> -1 출력
    // 찾았음 -> taxi 업데이트 -> return true
    public static boolean findPassenger() {
        Queue<TaxiNode> q = new LinkedList<>();
        q.offer(taxi);
        boolean[][] visit = new boolean[map.length][map.length];
        visit[taxi.i][taxi.j] = true;

        TaxiNode p = null;
        while(!q.isEmpty()) {
            int len = q.size();
            for(int l = 0; l < len; l++) {
                TaxiNode temp = q.poll();
                // 연료 바닥
                if(temp.b <= 0) {
                    return false;
                }
                // 승객이라면
                if(passenger[temp.i][temp.j] < 0) {
                    if(p == null) {
                        p = temp;
                    }
                    else {
                        if(p.i == temp.i) {
                            if(p.j > temp.j) {
                                p = temp;
                            }
                        }
                        else if(p.i > temp.i) {
                            p = temp;
                        }
                    }

                    continue;
                }

                // 승객이 아님
                for(int index = 0; index < 4; index++) {
                    int nextI = temp.i + dirI[index];
                    int nextJ = temp.j + dirJ[index];

                    if(nextI < 1 || nextI > N || nextJ < 1 || nextJ > N || map[nextI][nextJ] == 1 || visit[nextI][nextJ]) {
                        continue;
                    }
                    visit[nextI][nextJ] = true;
                    q.offer(new TaxiNode(nextI, nextJ, temp.b - 1));
                }
            }
            // 승객 찾았음
            if(p != null) {
                taxi = p;
                return true;
            }
        }

        return false;
    }

    // return -1 -> 실패
    // return 양수 -> 사용한 배터리 양
    public static int move(int target) {
        // 사용한 배터리 양
        int useB = 0;
        Queue<TaxiNode> q = new LinkedList<>();
        q.offer(taxi);
        boolean[][] visit = new boolean[map.length][map.length];
        visit[taxi.i][taxi.j] = true;

        while(!q.isEmpty()) {
            int len = q.size();
            for(int l = 0; l < len; l++) {
                TaxiNode temp = q.poll();
                // 목적지
                if(map[temp.i][temp.j] == target) {
                    if(useB > temp.b) {
                        return -1;
                    }
                    taxi = temp;
                    return useB;
                }

                // 연료 바닥
                if(useB > temp.b) {
                    return -1;
                }

                for(int index = 0; index < 4; index++) {
                    int nextI = temp.i + dirI[index];
                    int nextJ = temp.j + dirJ[index];

                    if(nextI < 1 || nextI > N || nextJ < 1 || nextJ > N || map[nextI][nextJ] == 1 || visit[nextI][nextJ]) {
                        continue;
                    }
                    visit[nextI][nextJ] = true;
                    q.offer(new TaxiNode(nextI, nextJ, temp.b));
                }
            }
            useB++;
        }

        return -1;
    }
}

class TaxiNode {
    int i;
    int j;
    int b;

    TaxiNode(int i, int j, int b) {
        this.i = i;
        this.j = j;
        this.b = b;
    }
}
