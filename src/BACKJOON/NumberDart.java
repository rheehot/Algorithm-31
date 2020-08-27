package BACKJOON;

import java.util.HashSet;
import java.util.Scanner;

public class NumberDart {
    public static int[][] map = new int[5][5];
    public static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                map[i][j] = scan.nextInt();
            }
        }

        String s = new String();
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                solution(i, j, 0, s);
            }
        }

        System.out.println(set.size());
    }

    public static int[] dirI = {0, 0, 1, -1};
    public static int[] dirJ = {1, -1, 0, 0};

    public static void solution(int i, int j, int depth, String s) {
        if(s.length() == 6) {
            if(!set.contains(s)) {
                set.add(s);
            }
            return;
        }

        for(int index = 0; index < 4; index++) {
            int tempI = i + dirI[index];
            int tempJ = j + dirJ[index];

            if(tempI < 0 || tempI >= 5 || tempJ < 0 || tempJ >= 5) {
                continue;
            }

            solution(tempI, tempJ, depth + 1, s + map[tempI][tempJ]);
        }
    }

}