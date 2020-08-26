package BACKJOON;

import java.util.Scanner;

public class SumNum2 {
    public static int[] nums;
    public static long M;
    public static int answer = 0;
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        M = scan.nextLong();

        nums = new int[N];

        for(int i = 0; i < N; i++) {
            nums[i] = scan.nextInt();
        }

        solution();

        System.out.println(answer);
    }

    public static void solution() {
        int startIndex = 0;
        int endIndex = startIndex;
        long sum = 0;

        while(true) {
            if(sum >= M) {
                sum -= nums[startIndex++];
            }
            else if(endIndex == nums.length) {
                break;
            }
            else {
                sum += nums[endIndex++];
            }

            if(sum == M) {
                answer++;
            }
        }
    }
}
