package Test;

import java.util.Scanner;

// 부채꼴
public class MidasTwo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int x = scan.nextInt();
        int y = scan.nextInt();

        int r = scan.nextInt();
        int d = scan.nextInt();

        int len = scan.nextInt();
        int[][] target = new int[len][2];
        for(int i = 0; i < len; i++) {
            target[i][0] = scan.nextInt();
            target[i][1] = scan.nextInt();
        }

        System.out.println(solution(x, y, r, d, target));

    }

    public static int solution(int x, int y, int r, int d, int[][] target) {
        int result = 0;
        for(int i = 0; i < target.length; i++) {
            // 원의 범위에서 벗어남
            if (getDistance(target[i][0], target[i][1]) > r) {
                continue;
            }

            if (Math.abs(getAngle(x, target[i][0], y, target[i][1])) <= d) {
                result++;
            }

        }
        return result;
    }

    public static double getDistance(int x, int y) {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    public static float getAngle(int x1, int x2, int y1, int y2) {
        int xDiff = x2 - x1;
        int yDiff = y2 - y1;
        return (float) (Math.atan2(yDiff, xDiff) * (180 / Math.PI));
    }
}
