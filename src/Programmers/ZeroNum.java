import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        
        Arrays.sort(arr);
        
        ArrayList<Integer> temp = new ArrayList<>();
        for(int a : arr) {
            if(a % divisor == 0) {
                temp.add(a);
            }
        }
        
        if(temp.isEmpty()) {
            temp.add(-1);
        }
        
        int[] answer = new int[temp.size()];
        for(int index = 0; index < temp.size(); index++) {
            answer[index] = temp.get(index);
        }
        return answer;
    }
}
