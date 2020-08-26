package BACKJOON;

import java.util.Scanner;
import java.util.Stack;

public class FingerGuitar {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int P = scan.nextInt();

        Stack<Integer>[] s = new Stack[7];
        for(int i = 1; i <= 6; i++) {
            s[i] = new Stack<Integer>();
        }

        int count = 0;
        for(int i = 0; i < N; i++) {
            int link = scan.nextInt();
            int plat = scan.nextInt();

            if(s[link].isEmpty()) {
                s[link].push(plat);
                count++;
            }
            else {
                while(!s[link].isEmpty() && s[link].peek() > plat) {
                    s[link].pop();
                    count++;
                }
                if(!s[link].isEmpty() && s[link].peek() == plat) {
                    continue;
                }

                s[link].push(plat);
                count++;
            }
        }

        System.out.println(count);
    }
}
