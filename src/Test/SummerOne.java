package Test;

import java.util.HashSet;
import java.util.Scanner;

public class SummerOne {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int p = scan.nextInt();

        System.out.println(solution(p));
    }

    public static int solution(int p) {
        while (true) {
            p++;
            HashSet<Integer> set = new HashSet<>();

            int temp = p;
            int dist = 10;
            boolean flag = false;
            while(temp != 0) {
                if (set.contains(temp % dist)) {
                    flag = true;
                    break;
                }

                set.add(temp % dist);
                temp = temp / dist;
            }
            if(flag) {
                continue;
            } else {
                return p;
            }
        }
    }
}
