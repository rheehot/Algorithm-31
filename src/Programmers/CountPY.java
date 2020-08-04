package Programmers;

public class CountPY {
    public static boolean solution(String s) {
         s = s.toLowerCase();

        int pNum = 0;
        int yNum = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'p') {
                pNum++;
            }
            if (c == 'y') {
                yNum++;
            }
        }
        if (pNum == yNum) {
            return true;
        }
        else {
            return false;
        }
    }
}
