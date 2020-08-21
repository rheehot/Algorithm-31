package BACKJOON;

import java.util.*;

public class AddressNumber {
    public static int[][] visit;
    public static int[][] map;

    public static int[] dirI = {-1, 0, 1, 0};
    public static int[] dirJ = {0, 1, 0, -1};

    public static int count = 1;
    public static int len = 0;
    public static ArrayList al = new ArrayList();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        len = scan.nextInt();

        map = new int[len][len];
        visit = new int[len][len];

        scan.nextLine();
        for(int i = 0; i < len; i++) {
            String t = scan.nextLine();
            for(int index = 0; index < len; index++) {
                if(t.charAt(index) == '0') {
                    map[i][index] = 0;
                }
                else {
                    map[i][index] = 1;
                }
            }
        }

        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                if(map[i][j] == 1 && visit[i][j] == 0) {
                    count = 1;
                    find(i, j);
                    al.add(count);
                }
            }
        }

        Collections.sort(al);

        System.out.println(al.size());

        for(int i = 0; i < al.size(); i++) {
            System.out.println(al.get(i));
        }
    }

    public static int find(int x, int y) {
        visit[x][y] = 1;
        for(int i = 0; i < 4; i ++) {
            int nx = x + dirI[i];
            int ny = y + dirJ[i];

            if(nx >= 0 && ny >= 0 && nx < len && ny < len) {
                if(map[nx][ny] == 1 && visit[nx][ny] == 0) {
                    find(nx, ny);
                    count++;
                }
            }
        }

        return count;
    }
}
