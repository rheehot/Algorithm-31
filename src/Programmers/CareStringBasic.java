class Solution {
    public boolean solution(String s) {
        if (s.length() != 4 && s.length() != 6) {
            return false;
        }
        for(int index = 0; index < s.length(); index++) {
            char c = s.charAt(index);
            if (c >= 'A' && c <= 'z') {
                return false;
            }
        }
        
        return true;
    }
}
