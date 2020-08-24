package BACKJOON;

import java.util.Arrays;
import java.util.Scanner;

public class Seven {
    public static int[] height = new int[9];
    public static boolean flag = false;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        for(int i = 0; i < 9; i++) {
            height[i] = scan.nextInt();
        }
        Arrays.sort(height);

        boolean[] visit = new boolean[9];

        solution(visit, 0, 0);
    }

    public static void solution(boolean[] visit, int heightSum, int count) {
        if(flag) {
            return;
        }
        if(count >= 7) {
            if(heightSum == 100) {
                flag = true;
                for(int i = 0; i < 9; i++) {
                    if(visit[i]) {
                        System.out.println(height[i]);
                    }
                }
            }
            return;
        }

        for(int i = 0; i < 9; i++) {
            if(!visit[i] && heightSum + height[i] <= 100) {
                visit[i] = true;
                solution(visit, heightSum + height[i], count + 1);
                visit[i] = false;
            }
        }
    }
}
