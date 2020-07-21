class Solution {
    public int solution(int n) {
        boolean[] yac = new boolean[n + 1];
        
        int answer = 0;
        for(int i = 1; i <= n; i++) {
            if (!yac[i] && n % i == 0) {
                answer += i;
                yac[i] = true;
                
                if(!yac[n / i]) {
                    answer += (n / i);
                    yac[n / i] = true;
                }
            }
        }
        
        return answer;
    }
}
