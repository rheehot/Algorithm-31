package Test;

import java.util.HashMap;
import java.util.Scanner;

// 공통 접두사 구하기
public class MidasOne {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        String[] str = new String[n];
        scan.nextLine();

        for(int i = 0; i < n; i++) {
            str[i] = scan.nextLine();
        }

        System.out.println(solution(str));

        String[] participant = {"aa", "bb"};
        String[] completion = {"aa", "bb"};
        HashMap<String, Integer> map = new HashMap<>();



    }


    public static String solution(String[] strs) {
        if(strs.length == 0) return "";

        StringBuilder result = new StringBuilder();
        boolean same = true;

        for(int i = 0; i < strs[0].length(); i++) {
            char temp = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++) {
                if(strs[j].length() <= i) {
                    same = false;
                    break;
                }
                else if(temp == strs[j].charAt(i)) {
                    continue;
                }
                same = false;
                break;
            }

            if(same) result.append(temp);
            else break;
        }


        return result.toString();
    }
}
