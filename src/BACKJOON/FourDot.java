package BACKJOON;

import java.util.Scanner;

public class FourDot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] x = new int[3];
        int[] y = new int[3];
        for(int i = 0; i < 3; i++) {
            x[i] = scan.nextInt();
            y[i] = scan.nextInt();
        }

        result(x);
        result(y);
    }

    public static void result(int[] arr) {
        if(arr[0] == arr[1]) {
            System.out.print(arr[2] + " ");
        }
        else if (arr[0] == arr[2]) {
            System.out.print(arr[1] + " ");
        }
        else {
            System.out.print(arr[0] + " ");
        }
    }
}
