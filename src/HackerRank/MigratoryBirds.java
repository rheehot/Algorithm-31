package src.HackerRank;

/*
 * https://www.hackerrank.com/challenges/migratory-birds/problem
 */

import java.util.*;
public class MigratoryBirds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] birds = new int[n];

        for(int i = 0; i < n; i++) {
            birds[i] = scan.nextInt();
        }

        System.out.print(migratoryBirds(birds));
    }

    static int migratoryBirds(int[] birds) {
        int[] birdsType = new int[6];
        for(int i = 0; i < birds.length; i++) {
            birdsType[birds[i]]++;
        }

        int max = 0;
        int maxIndex = -1;
        for(int i = 5; i > 0; i--) {
            if (birdsType[i] >= max) {
                max = birdsType[i];
                maxIndex = i;
            }
        }

        return maxIndex;
    }
}