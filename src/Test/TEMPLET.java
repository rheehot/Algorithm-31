package Test;

public class TEMPLET {
    // 소수 찾기
    private static boolean isPrimeNumber(int x) {
        if(x == 1) {
            return false;
        }
        for(int i = 2; i * i <= x; i++) {
            if(x % i == 0) {
                return false;
            }
        }
        return true;
    }

    // 팰린드롬
    private static boolean isPalindrome(int x) {
        char[] arr = String.valueOf(x).toCharArray();
        int s = 0, e = arr.length - 1;
        while(s < e) {
            if(arr[s] != arr[e])
                return false;

            s++;
            e--;
        }
        return true;
    }
}
