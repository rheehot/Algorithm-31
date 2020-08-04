package Programmers;

import java.util.*;
class SortStringDesc {
    public String solution(String s) {
        
        char[] temp = new char[s.length()];
        for(int index = 0; index < s.length(); index++) {
            temp[index] = s.charAt(index);
        }
        Arrays.sort(temp);
        String answer = "";
        for(int index = temp.length - 1; index >= 0; index--) {
            answer += temp[index];
        }
        return answer;
    }
}
