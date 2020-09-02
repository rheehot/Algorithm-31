package BACKJOON;

import java.util.*;

public class Multiple {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long A = scan.nextLong();
        long B = scan.nextLong();
        long C = scan.nextLong();

        System.out.println(solution(A % C, B, C));
    }

    public static long solution(long a, long b, long c) {
        if(b == 1) {
            return a;
        }

        long temp = solution(a, b / 2, c) % c;

        if(b % 2 == 0) {
            return (temp * temp) % c;
        }
        else {
            return ((temp * temp) % c) * a % c;
        }
    }
}
