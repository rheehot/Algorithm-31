package src.Programmers;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/12904?language=java
 */
import java.util.*;
public class Palindrome {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String ex = scan.next();

        System.out.print(solution(ex));
    }

    static int solution(String s) {
        int max = 0;

        int[][] d = new int[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j < s.length(); j++) {
                if (i == j) {
                    d[i][j] = 1;
                }
                else {

                }
            }
        }

        for(int i = 0; i < s.length() - 1; i++) {
            for(int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    int k = 1;
                    while(true) {
                        if(i + k == j - k) {
                            if (max < j - i + 1) {
                                max = j - i + 1;
                            }
                            break;
                        }

                        if (s.charAt(i + k) != s.charAt(j - k)) {
                            break;
                        }
                        k++;
                    }
                }
            }
        }
        return max;
    }
}
