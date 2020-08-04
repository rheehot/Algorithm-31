package Programmers;

class MakeWord {
    public String solution(String s) {
        s = s.replace(" ", "/");
    
        String answer = "";
        int gap = 'a' - 'A';
        int i = 0;
        for(int index = 0; index < s.length(); index++) {
            char temp = s.charAt(index);
            if (temp == '/') {
                answer += " ";
                i = 0;
                continue;
            }
            
            // 짝수
            if (i % 2 == 0) {
                if (temp >= 'a' && temp <= 'z') {
                    temp -= gap;
                }
            }
            // 홀수
            else {
                if (temp >= 'A' && temp <= 'Z') {
                    temp += 32;
                }
            }
            answer += temp;
            i++;
        }
        return answer;
    }
}
