package BACKJOON;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SortWord {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.nextLine();

        String[] s = new String[N];
        for(int i = 0; i < N; i++) {
            s[i] = scan.nextLine();
        }

        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() != o2.length()) {
                    return Integer.compare(o1.length(), o2.length());
                }

                return o1.compareTo(o2);
            }
        });

        System.out.println(s[0]);
        for(int i = 1; i < N; i++) {
            if(s[i].equals(s[i - 1])) {
                continue;
            }
            System.out.println(s[i]);
        }
    }
}
