package Programmers;

class HidePhoneNumber {
    public String solution(String phone_number) {
        String answer = "";
        int len = phone_number.length();
        for(int index = 0; index < len; index++) {
            if(index < len - 4) {
                answer += "*";
            }
            else {
                answer += phone_number.charAt(index);
            }
        }
        
        return answer;
    }
}
