package BACKJOON;

import java.util.Arrays;
import java.util.Scanner;

public class ChoiceSubject {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] basic = new int[4];
        for(int i = 0; i < 4; i++) {
            basic[i] = scan.nextInt();
        }

        Arrays.sort(basic);
        int sum = basic[1] + basic[3] + basic[2];

        sum += Math.max(scan.nextInt(), scan.nextInt());

        System.out.println(sum);
    }
}
