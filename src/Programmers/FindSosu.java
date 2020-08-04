package Programmers;

class FindSosu {
    public int solution(int n) {
        int answer = 0;
        boolean[] sosu = new boolean[n + 1];
        for(int i = 2; i < sosu.length; i++) {
            if(!sosu[i]) {
                answer++;
                
                int temp = 2;
                while(true) {
                    if (i * temp >= sosu.length) {
                        break;
                    }
                    sosu[i * temp] = true;
                    temp++;
                }
            }
        }
        
        return answer;
    }
}
