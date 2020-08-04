package Programmers;

class JudgeRoot {
    public long solution(long n) {
        
        double s = Math.sqrt(n);
        if ((long)s < s) {
            return -1;
        } 
        else {
            long temp = (long)s;
            temp++;
            return temp * temp;
        }
    }
}
