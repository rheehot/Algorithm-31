class Solution {
    public String solution(int a, int b) {
        int[] dayNum = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] day = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        
        int days = 0;
        for(int index = 1; index < a; index++) {
            days += dayNum[index];
        }
        days += b;
        
        days %= 7;
        return day[days];
    }
}
