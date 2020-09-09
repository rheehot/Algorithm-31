package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SosuAndPalindrom {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        while(true) {
            if(isPrimeNumber(N) && isPalindrome(N)) {
                bw.write(N+"");
                break;
            }

            N++;
        }

        bw.flush();
        bw.close();
    }

    static boolean isPrimeNumber(int x) {
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

    static boolean isPalindrome(int x) {
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
