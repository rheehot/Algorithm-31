package BACKJOON;

import java.util.Arrays;
import java.util.Scanner;

public class CutTree {
    public static int[] trees;
    public static int M;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        M = scan.nextInt();

        trees = new int[N];
        for(int i = 0; i < N; i++) {
            trees[i] = scan.nextInt();
        }

        Arrays.sort(trees);

        int minH = 0;
        int maxH = trees[N - 1];
        int middle;

        while(minH <= maxH) {
            middle = (minH + maxH) / 2;
            long h = judge(middle);
            if(h >= M) {
                minH = middle + 1;
            }
            else {
                maxH = middle - 1;
            }
        }

        System.out.println(maxH);
    }

    public static long judge(int middle) {
        long h = 0;
        for(int i = 0; i < trees.length; i++) {
            if(trees[i] <= middle) {
                continue;
            }
            h += (trees[i] - middle);
        }

        return h;
    }
}
