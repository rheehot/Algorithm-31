package src.Programmers;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/12980?language=java
 */

import java.util.*;
public class Jump {
    public static int solution(int n) {
        int ans = 0;

        while(true) {
            if (n == 1 || n == 2) {
                ans++;
                break;
            }
            if (n % 2 != 0) {
                ans++;
                n -= 1;
            }
            n /= 2;
        }

        return ans;
    }
}
