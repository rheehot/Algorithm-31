package BACKJOON;

import java.util.Scanner;

public class FindBunsu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int X = scan.nextInt();

        // 등차 수열을 구하기 위함
        int line = 0;
        int cnt = 0;
        while(cnt < X) {
            line++;
            cnt = line * (line + 1) / 2;
        }

        // 아래부터
        if(line % 2 != 0) {
            int top = 1 + (cnt - X);
            int bottom = line - (cnt - X);
            System.out.println(top + "/" + bottom);
        }
        // 위에부터
        else {
            int top = line - (cnt - X);
            int bottom = 1 + (cnt - X);
            System.out.println(top + "/" + bottom);
        }

    }
}
