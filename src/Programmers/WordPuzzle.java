package Programmers;

import java.util.*;

public class WordPuzzle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        String[] strs = new String[n];

        scan.nextLine();
        for(int i = 0; i < n; i++) {
            strs[i] = scan.nextLine();
        }

        String t = scan.nextLine();

        System.out.print(solution(strs, t));
    }

    public static int solution(String[] strs, String t) {
        int answer = Integer.MAX_VALUE;
        int[] dp = new int[t.length()];
        for(int index = 1; index < t.length() + 1; index++) {
            for(int i = 0; i < strs.length; i++) {
                String puzzle = strs[i];

                if(index < puzzle.length()) {
                    continue;
                }

                if(puzzle.equals(t.substring(index - puzzle.length(), index))) {
                    if(index - puzzle.length() == 0) {
                        dp[index - 1] = 1;
                        continue;
                    }
                    if(dp[index - puzzle.length() - 1] > 0) {
                        dp[index - 1] = dp[index - 1] == 0 ? dp[index - puzzle.length() - 1] + 1 : Math.min(dp[index - 1], dp[index - puzzle.length() - 1] + 1);
                    }
                }
            }
        }
        answer = dp[dp.length - 1];
        if(answer == 0) {
            return -1;
        }
        return answer;
    }
}
