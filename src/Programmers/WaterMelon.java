package Programmers;

class WaterMelon {
    public String solution(int n) {
        String format = "수박";
    
        String answer = "";
        for(int i = 0; i < n / 2; i++) {
            answer += format;
        }
        
        if(n % 2 != 0) {
            answer += "수";
        }
        return answer;
    }
}
