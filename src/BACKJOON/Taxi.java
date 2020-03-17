package BACKJOON;

import java.util.Scanner;

public class Taxi {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int r = scan.nextInt();

        System.out.printf("%.6f\n", (double)r * r * Math.PI);
        System.out.printf("%.6f\n", (double)2 * r * r);
    }
}
