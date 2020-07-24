import java.util.*;
class Solution {
    public long solution(long n) {
        
        if(n <= 10) {
            return n;
        }
        
        ArrayList<Integer> temp = new ArrayList<>();
        
        while(n > 0) {
            temp.add((int)(n % 10));
            n /= 10;
        }
        
        Collections.sort(temp);

        long answer = 0;
        long dist = 1;
        for(int i = 0; i < temp.size(); i++) {
            answer += (temp.get(i) * dist);
            dist *= 10;
        }
        
        return answer;
    }
}
