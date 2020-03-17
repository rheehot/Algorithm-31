package Programmers;

public class MakeSosu {

    public static int solution(int[] nums) {
        int answer  = 0;
        boolean chk = false;

        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                for(int k = j + 1; k <nums.length; k++) {
                    int num = nums[i] + nums[j] + nums[k];
                    if(num >= 2) {
                        chk = isSosu(num);
                    }
                    if(chk) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    public static boolean isSosu(int sum) {
        if(sum == 2) {
            return true;
        }
        for(int i = 2; i < sum; i++) {
            if (sum % i == 0) {
                return false;
            }
        }
        return true;
    }
}
