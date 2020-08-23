package BACKJOON;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MoveKnight {

    static int[] dirI = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dirJ = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int T = scan.nextInt();
        for(int t = 0; t < T; t++) {
            int n = scan.nextInt();

            boolean[][] visit = new boolean[n][n];

            int startI = scan.nextInt();
            int startJ = scan.nextInt();
            visit[startI][startJ] = true;

            int targetI = scan.nextInt();
            int targetJ = scan.nextInt();

            if(startI == targetI && startJ == targetJ) {
                System.out.println(0);
                continue;
            }

            Queue<KnightIndex> q = new LinkedList<>();
            q.offer(new KnightIndex(startI, startJ, 0));

            while(!q.isEmpty()) {
                KnightIndex temp = q.poll();
                if(temp.i == targetI && temp.j == targetJ) {
                    System.out.println(temp.count);
                    break;
                }

                for(int index = 0; index < 8; index++) {
                    int tempI = temp.i + dirI[index];
                    int tempJ = temp.j + dirJ[index];

                    if(tempI < 0 || tempI >= n || tempJ < 0 || tempJ >= n || visit[tempI][tempJ]) {
                        continue;
                    }

                    visit[tempI][tempJ] = true;
                    q.offer(new KnightIndex(tempI, tempJ, temp.count + 1));
                }
            }

        }
    }
}

class KnightIndex {
    int i;
    int j;
    int count;

    KnightIndex(int i, int j, int count) {
        this.i = i;
        this.j = j;
        this.count = count;
    }
}
