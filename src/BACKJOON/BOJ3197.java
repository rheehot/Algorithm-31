package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ3197 {
    static int R, C;
    static int[][] map;
    static Queue<SwanNode> waterQ = new LinkedList<>();
    static Queue<SwanNode> swanQ = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        int swan = -1;
        for(int row = 0; row < R; row++) {
            String str = br.readLine();
            for(int col = 0; col < C; col++) {
                char temp = str.charAt(col);
                if(temp == 'X') {
                    map[row][col] = 1;
                    continue;
                }
                if(temp == 'L') {
                    map[row][col] = swan;
                    if(swan == -1) {
                        swanQ.offer(new SwanNode(row, col));
                    }
                    swan--;
                }

                waterQ.offer(new SwanNode(row, col));
            }
        }

        int days = 0;
        while(!swanMove()) {
            melting();
            days++;
        }

        bw.write(days + "");
        bw.flush();
        bw.close();
    }

    static int[] dirI = {0, 0, 1, -1};
    static int[] dirJ = {1, -1, 0, 0};
    public static boolean swanMove() {
        Queue<SwanNode> searchSwan = new LinkedList<>();
        while(!swanQ.isEmpty()) {
            SwanNode temp = swanQ.poll();

            boolean flag = true;
            for(int index = 0; index < 4; index++) {
                int nextI = temp.i + dirI[index];
                int nextJ = temp.j + dirJ[index];
                // 지도를 넘어감
                if(nextI < 0 || nextI >= R || nextJ < 0 || nextJ >= C) {
                    continue;
                }
                // 백조 만남
                if(map[nextI][nextJ] == -2) {
                    return true;
                }
                // 빙판
                if(map[nextI][nextJ] == 1) {
                    if(flag) {
                        searchSwan.offer(temp);
                        flag = false;
                    }
                    continue;
                }
                // 방문함
                if(map[nextI][nextJ] == -1) {
                    continue;
                }
                map[nextI][nextJ] = -1;
                swanQ.offer(new SwanNode(nextI, nextJ));
            }
        }
        swanQ = searchSwan;

        return false;
    }

    public static void melting() {
        int size = waterQ.size();
        for(int s = 0; s < size; s++) {
            SwanNode temp = waterQ.poll();

            for(int index = 0; index < 4; index++) {
                int nextI = temp.i + dirI[index];
                int nextJ = temp.j + dirJ[index];
                if(nextI < 0 || nextI >= R || nextJ < 0 || nextJ >= C) {
                    continue;
                }
                if(map[nextI][nextJ] == 1) {
                    map[nextI][nextJ] = 0;
                    waterQ.offer(new SwanNode(nextI, nextJ));
                }
            }
        }
    }

}

class SwanNode {
    int i;
    int j;

    SwanNode(int i, int j) {
        this.i = i;
        this.j = j;
    }
}