package BACKJOON;

import java.util.Scanner;

public class GroupWord {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        int result = 0;
        for(int i = 0; i < T; i++) {
            String word = scan.next();
            boolean ch = check(word);
            if (ch) {
                result++;
            }
        }
        System.out.println(result);
    }

    public static boolean check(String word) {
        boolean[] visit = new boolean[26];

        for(int j = 0; j < word.length(); j++) {
            char c = word.charAt(j);
            if (visit[c - 'a']) {
                return false;
            }
            if (j < word.length() - 1 && c != word.charAt(j + 1)) {
                visit[c - 'a'] = true;
            }
        }
        return true;
    }
}
