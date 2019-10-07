package HackerRank;

/*
 * https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem
 */

import java.util.*;
public class BreakingTheRecords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] scores = new int[n];
        for(int i = 0; i < n; i++) {
            scores[i] = scan.nextInt();
        }

        int[] result = breakingRecords(scores);
        for(int i = 0; i < 2; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static int[] breakingRecords(int[] scores) {
        int min = 0;
        int max = 0;
        int min_break_count = 0;
        int max_break_count = 0;

        for(int i = 0; i < scores.length; i++) {
            if (i == 0) {
                min = scores[i];
                max = scores[i];
                continue;
            }
            if (scores[i] > max) {
                max_break_count++;
                max = scores[i];
            }
            else if (scores[i] < min) {
                min_break_count++;
                min = scores[i];
            }
        }

        int[] result = new int[2];
        result[0] = max_break_count;
        result[1] = min_break_count;

        return result;
    }
}