package BACKJOON;

import java.util.Arrays;
import java.util.Scanner;

public class ChoiceNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int M = scan.nextInt();

        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = scan.nextInt();
        }
        Arrays.sort(arr);

        int start = 0;
        int end = 0;
        long diff = 0;
        long answer = Integer.MAX_VALUE;

        while(start <= end && end < N) {
            if(diff >= M) {
                answer = Math.min(answer, diff);

                if(start == end) {
                    end++;
                    if(end == N) {
                        break;
                    }

                    diff = arr[end] - arr[start];
                }
                else {
                    start++;
                    diff = arr[end] - arr[start];
                }
            }
            else {
                end++;
                if(end == N) {
                    break;
                }
                diff = arr[end] - arr[start];
            }
        }

        System.out.println(answer);
    }
}



