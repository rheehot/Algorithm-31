package BACKJOON;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class RoomChoice {
    public static int N;
    public static int[][] table;
    public static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();
        table = new int[N][2];

        for(int i = 0; i < N; i++) {
            table[i][0] = scan.nextInt();
            table[i][1] = scan.nextInt();
        }

        Arrays.sort(table, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) {
                    return Integer.compare(o1[0], o2[0]);
                }
                else {
                    return Integer.compare(o1[1], o2[1]);
                }
            }
        });

        int end = -1;
        int count = 0;
        for(int i = 0; i < N; i++) {
            if(table[i][0] >= end) {
                end = table[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}
