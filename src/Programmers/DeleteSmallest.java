import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        if (arr.length < 2) {
            int[] answer = {-1};
            return answer;
        }
        
        int[] answer = new int[arr.length - 1];
        int min = Integer.MAX_VALUE;
        
        for(int a : arr) {
            if (a < min) {
                min = a;
            }
        }
        
        int i = 0;
        for(int index = 0; index < answer.length; index++) {
            if (arr[i] == min) {
                i++;
            }
            answer[index] = arr[i];
            i++;
        }
        
        return answer;
        
    }
}
