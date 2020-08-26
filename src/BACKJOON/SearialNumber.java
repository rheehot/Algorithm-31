package BACKJOON;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SearialNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        String[] strs = new String[N];
        scan.nextLine();
        for(int i = 0; i < N; i++) {
            strs[i] = scan.nextLine();
        }

        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() != o2.length()) {
                    return o1.length() - o2.length();
                }

                int o1Len = 0;
                for(int i = 0; i < o1.length(); i++) {
                    char temp = o1.charAt(i);

                    if(temp >= '0' && temp <= '9') {
                        o1Len += (temp - '0');
                    }
                }

                int o2Len = 0;
                for(int i = 0; i < o2.length(); i++) {
                    char temp = o2.charAt(i);
                    if(temp >= '0' && temp <= '9') {
                        o2Len += (temp - '0');
                    }
                }

                if(o2Len != o1Len) {
                    return o1Len - o2Len;
                }

                return o1.compareTo(o2);
            }
        });

        for(int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
    }
}
