package Programmers;

class XGapNumber {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        answer[0] = x;
        
        for(int index = 1; index < n; index++) {
            answer[index] = answer[index - 1] + x;
        }
        
        return answer;
    }
}
