import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        int[] students = new int[n + 1];
        for(int l : lost) {
            students[l]--;
        }
        for(int r : reserve) {
            students[r]++;
        }
        
        for(int index = 1; index < students.length; index++) {
            // 여분 체육복이 있다면
            if(students[index] > 0) {
                if(students[index - 1] < 0) {
                    students[index - 1]++;
                    students[index]--;
                }
                else if(index + 1 < students.length && students[index + 1] < 0) {
                    students[index + 1]++;
                    students[index]--;
                }
            }
        }
        
        int answer = 0;
        for(int index = 1; index < students.length; index++) {
            if(students[index] >= 0) {
                answer++;
            }
        }
        return answer;
    }
}
