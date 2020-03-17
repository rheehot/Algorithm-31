package BACKJOON;

import java.util.Scanner;

public class Teret {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        for(int i = 0; i < T; i++) {
            int x1 = scan.nextInt();
            int y1 = scan.nextInt();
            int r1 = scan.nextInt();

            int x2 = scan.nextInt();
            int y2 = scan.nextInt();
            int r2 = scan.nextInt();

            double r = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

            // 두 원이 일치 -> 무한
            if (x1 == x2 && y1 == y2 && r1 == r2) {
                System.out.println(-1);
            }
            // 두 원이 너무 멀 경우
            // 하나의 원이 다른 하나의 원 안에 있고, 중점이 같지만 두 원이 만나지 않을때
            // 하나의 원이 다른 하나의 원 안에 있고 중점이 다른데 만나지 않을때
            else if (r > r1 + r2 || x1 == x2 && y1 == y2 && r1 != r2 || r < Math.abs(r1 - r2)) {
                System.out.println(0);
            }
            // 두 원이 한점에서 만나는 경우 (외접, 내접)
            else if (r == r1 + r2 || Math.abs(r1 - r2) == r) {
                System.out.println(1);
            }
            else {
                System.out.println(2);
            }
        }
    }
}
