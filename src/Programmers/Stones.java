package Programmers;

import java.util.*;

public class Stones {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] stones = new int[n];

        for(int i = 0; i < n; i++) {
            stones[i] = scan.nextInt();
        }
        int k = scan.nextInt();
        System.out.println(solution(stones, k));
    }

    public static int solution(int[] stones, int k) {
        int start = Arrays.stream(stones).min().getAsInt();
        int end = Arrays.stream(stones).max().getAsInt();
        int answer = 0;
        while(start <= end) {
            int middle = (start + end) / 2;
            if (cross(stones, middle, k)) {
                answer = middle;
                start = middle + 1;
            }
            else {
                end = middle - 1;
            }
        }

        return answer;
    }

    public static boolean cross(int[] stones, int middle, int k) {

        for(int i = 0; i < stones.length; i++) {
            System.out.print(stones[i] + " ");
        }
        System.out.println();

        Arrays.setAll(stones, i -> stones[i] - middle + 1);

        int cnt = 0;
        int max = 0;
        for(int stone : stones) {
            if (cnt > 0 && stone > 0) {
                max = Math.max(max, cnt);
                cnt = 0;
            }
            else if (stone <= 0) {
                cnt++;
            }
        }

        return (Math.max(max, cnt) < k);
    }
}
