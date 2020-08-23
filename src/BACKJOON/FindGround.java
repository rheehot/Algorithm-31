package BACKJOON;

import java.util.*;

public class FindGround {
    public static int M, N, K;
    public static int[][] map;
    public static boolean[][] visit;

    public static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        M = scan.nextInt();
        N = scan.nextInt();
        K = scan.nextInt();

        map = new int[M][N];
        visit = new boolean[M][N];

        for(int index = 0; index < K; index++) {
            int j1 = scan.nextInt();
            int i1 = scan.nextInt();
            int j2 = scan.nextInt();
            int i2 = scan.nextInt();

            for(int i = i1; i < i2; i++) {
                for(int j = j1; j < j2; j++) {
                    map[i][j] = 1;
                }
            }
        }

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 0 && !visit[i][j]) {
                    visit[i][j] = true;
                    map[i][j] = 1;
                    judge(i, j);
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for(int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }

    public static int[] dirI = {0, 0, 1, -1};
    public static int[] dirJ = {1, -1, 0, 0};

    public static void judge(int i, int j) {
        int w = 1;
        Queue<GroundIndex> q = new LinkedList<>();
        q.offer(new GroundIndex(i, j));

        while(!q.isEmpty()){
            GroundIndex temp = q.poll();

            for(int index = 0; index < 4; index++) {
                int tempI = temp.i + dirI[index];
                int tempJ = temp.j + dirJ[index];

                if(tempI < 0 || tempI >= M || tempJ < 0 || tempJ >= N) {
                    continue;
                }
                if(map[tempI][tempJ] == 0 && !visit[tempI][tempJ]) {
                    w++;
                    map[tempI][tempJ] = 1;
                    visit[tempI][tempJ] = true;

                    q.offer(new GroundIndex(tempI, tempJ));
                }
            }
        }

        list.add(w);
    }
}

class GroundIndex {
    int i;
    int j;

    GroundIndex(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
