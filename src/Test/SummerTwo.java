package Test;

import java.util.ArrayList;
import java.util.Scanner;

public class SummerTwo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long n = scan.nextLong();

        System.out.println(solution(n));
    }

    public static long solution(long n) {
        ArrayList<Long> list = new ArrayList<>();
        long dist = 1;
        list.add(dist);
        while(true) {
            if(list.size() >= n) {
                return list.get((int) (n - 1));
            }

            dist *= 3;

            int size = list.size();
            list.add(dist);
            for(int i = 0; i < size; i++) {
                list.add(list.get(i) + dist);
            }
        }
    }
}
