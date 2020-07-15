import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int index = 0; index < commands.length; index++) {
            int i = commands[index][0];
            int j = commands[index][1];
            int k = commands[index][2];
            
            int[] temp = new int[j - i + 1];
            
            for(int idx = 0; idx < temp.length; idx++) {
                temp[idx] = array[i + idx - 1];
            }
            
            Arrays.sort(temp);
            answer[index] = temp[k - 1];
        }
        
        return answer;
    }
}
