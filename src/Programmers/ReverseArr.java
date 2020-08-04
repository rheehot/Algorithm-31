package Programmers;

import java.util.*;
class ReverseArr {
    public int[] solution(long n) {
        ArrayList<Integer> temp = new ArrayList<>();
        
        while(n > 0) {
            int t = (int) (n % 10);
            temp.add(t);
            n /= 10;
        }
        
        int[] answer = new int[temp.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = temp.get(i);
        }
        
        return answer;
    }
}
