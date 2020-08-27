package BACKJOON;

import java.util.HashSet;
import java.util.Scanner;

public class BlackFriday {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        long w = scan.nextLong();

        long[] weight = new long[N];
        HashSet<Long> set = new HashSet<>();
        for(int i = 0; i < N; i++) {
            weight[i] = scan.nextLong();
            set.add(weight[i]);
        }

        for(int i = 0; i < N; i++) {
            if(weight[i] == w) {
                System.out.println(1);
                return;
            }
            for(int j = 0; j < N; j++) {
                if(i == j) {
                    continue;
                }

                if(weight[i] + weight[j] == w) {
                    System.out.println(1);
                    return;
                }

                long temp = w - weight[i] - weight[j];
                if(temp != weight[i] && temp != weight[j] && set.contains(temp)) {
                    System.out.println(1);
                    return;
                }
            }
        }

        System.out.println(0);
    }
}
