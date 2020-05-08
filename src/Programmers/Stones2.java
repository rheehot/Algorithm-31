package Programmers;

import java.util.Arrays;
import java.util.Scanner;

public class Stones2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int distance = scan.nextInt();
        int index = scan.nextInt();
        int[] rocks = new int[index];
        for(int i = 0 ; i < index; i++) {
            rocks[i] = scan.nextInt();
        }
        int n = scan.nextInt();

        System.out.println(solution(distance, rocks, n));
    }

    public static int solution (int distance, int[] rocks, int n) {
        int start = 1;
        int end = distance;
        Arrays.sort(rocks);

        int answer = 0;
        while(start <= end) {
            int middle = (start + end) / 2;

            if (judge(rocks, middle, n, distance)) {
                answer = middle > answer ? middle : answer;
                start = middle + 1;
            }
            else {
                end = middle - 1;
            }

        }
        return answer;
    }

    public static boolean judge(int[] rocks, int middle, int n, int distance) {
        int cnt = 0;
        int prev = 0;
        for(int rock : rocks) {
            if (rock - prev < middle) {
                cnt++;
            }
            else {
                prev = rock;
            }
        }

        if (distance - prev < middle) {
            cnt++;
        }

        if (cnt <= n) {
            return true;
        }
        else {
            return false;
        }
    }
}
