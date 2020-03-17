package BACKJOON;

import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while(true) {
            int[] height = new int[3];
            height[0] = scan.nextInt();
            height[1] = scan.nextInt();
            height[2] = scan.nextInt();

            if (height[0] == 0 && height[1] == 0 && height[2] == 0) {
                break;
            }

            int sum = (height[0] * height[0]) + (height[1] * height[1]) + (height[2] * height[2]);
            int max = Math.max(height[0], Math.max(height[1], height[2]));
            sum -= (max * max);

            if (max * max == sum) {
                System.out.println("right");
            }
            else {
                System.out.println("wrong");
            }
        }
    }
}
