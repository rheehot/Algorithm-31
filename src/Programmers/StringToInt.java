import java.util.*;
class Solution {
    public int solution(String s) {
        if (s.charAt(0) == '+') {
            String temp = s.substring(1);
            return Integer.parseInt(temp);
        }
        else if (s.charAt(0) == '-') {
            String temp = s.substring(1);
            int tempNum = Integer.parseInt(temp);
            return tempNum * -1;
        }
        else {
            return Integer.parseInt(s);
        }
    }
}
