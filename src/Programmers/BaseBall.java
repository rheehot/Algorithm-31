package Programmers;

import java.util.Scanner;

public class BaseBall {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        int[][] b = new int[n][3];

        for(int i = 0; i < n; i++) {
            b[i][0] = scan.nextInt();
            b[i][1] = scan.nextInt();
            b[i][2] = scan.nextInt();
        }

        solution(b);
    }

    public static int solution(int[][] baseball) {
        int result = 0;
        for(int i = 111; i <= 999; i++) {

            String tempI = Integer.toString(i);

            boolean[] visit = new boolean[10];
            for(int index = 0; index < 3; index++) {
                int tempNum = tempI.charAt(index) - '0';
                if(visit[tempNum]) {
                    continue;
                }

                visit[tempNum] = true;
            }

            if(judge(tempI, baseball)) {
                result++;
            }
        }
        return result;
    }

    public static boolean judge(String number, int[][] baseball) {

        for(int row = 0; row < baseball.length; row++) {
            int strike = 0;
            int ball = 0;

            boolean[] visit = new boolean[3];

            for(int index = 0; index < 3; index++) {
                
            }


            if (strike != baseball[row][1] || ball != baseball[row][2]) {
                return false;
            }
        }
        return true;
    }
}
