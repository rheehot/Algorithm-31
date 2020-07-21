class Solution {
    public String solution(String[] seoul) {
        for(int index = 0; index < seoul.length; index++) {
            if(seoul[index].equals("Kim")) {
                String answer = "김서방은 ";
                answer += index;
                answer += "에 있다";
                return answer;
            }
        }
        return "";
    }
}
