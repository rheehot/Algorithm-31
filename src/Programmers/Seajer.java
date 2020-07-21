class Solution {
    public String solution(String s, int n) {
        
        String answer = "";
        for(int index = 0; index < s.length(); index++) {
            char c = s.charAt(index);
            if(c >= 'A' && c <= 'Z') {
                char tempC = (char)(c + n);
                if (tempC <= 'Z') {
                    answer += tempC;
                    continue;
                }
                while(tempC > 'Z') {
                    tempC -= 26;
                }
                answer += tempC;
            }
            else if (c >= 'a' && c <= 'z') {
                char tempC = (char)(c + n);
                if (tempC <= 'z') {
                    answer += tempC;
                    continue;
                }
                while(tempC > 'z') {
                    tempC -= 26;
                }
                answer += tempC;
            }
            else {
                answer += c;
            }
        }
        
        return answer;
    }
}
