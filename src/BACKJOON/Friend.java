package BACKJOON;

import java.util.Scanner;

public class Friend {
    public static boolean[][] map;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int people = scan.nextInt();
        map = new boolean[people][people];
        scan.nextLine();

        for(int i = 0; i < people; i++) {
            String temp = scan.nextLine();
            for(int j = 0; j < people; j++) {
                if(temp.charAt(j) == 'Y') {
                    map[i][j] = true;
                }
            }
        }

        int max = 0;
        for(int i = 0; i < people; i++) {
            int a = 0;
            for(int j = 0; j < people; j++) {
                if(i == j) {
                    continue;
                }

                if(judge(i, j)) {
                    a++;
                }
            }

            if(max < a) {
                max = a;
            }

        }

        System.out.println(max);
    }

    public static boolean judge(int start, int target) {
        if(map[start][target]) {
            return true;
        }

        for(int i = 0; i < map.length; i++) {
            if(map[start][i] && map[target][i]) {
                return true;
            }
        }

        return false;
    }
}
