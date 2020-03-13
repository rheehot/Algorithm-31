package BACKJOON;

import java.util.Scanner;

public class Fly {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int T = scan.nextInt();
        for(int i = 0; i < T; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            int distance = y - x;
            int result = 1;
            int position = 0;

            while(distance > position) {
                result++;
                position += distance / 2;
            }
            System.out.println(result - 1);
        }
    }
}
