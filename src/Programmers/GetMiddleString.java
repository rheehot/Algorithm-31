class Solution {
    public String solution(String s) {
        // 길이가 짝수
        if(s.length() % 2 == 0) {
            int index = s.length() / 2;
            return s.substring(index - 1, index + 1);
        }
        // 길이가 홀수
        else {
            int index = s.length() / 2;
            return s.substring(index, index + 1);
        }
    }
}
