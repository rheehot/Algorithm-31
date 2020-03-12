package BACKJOON;

import java.util.Scanner;

public class Snail {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int A = scan.nextInt();
        int B = scan.nextInt();
        int V = scan.nextInt();
        V -= A;

        if (V <= 0) {
            System.out.println(1);
        }
        else {

            int day = (V / (A - B));

            if ((V % (A - B)) == 0) {
                System.out.println(day + 1);
            }
            else {
                System.out.println(day + 2);
            }
        }
    }

    public static void snailtwo() {
        Scanner scan = new Scanner(System.in);

        int A = scan.nextInt();
        int B = scan.nextInt();
        int V = scan.nextInt();

        if((V - B) % (A - B) == 0) {
            System.out.println((V - B) / (A - B));
        }
        else {
            System.out.println((V - B) / (A - B) + 1);
        }
    }
}
