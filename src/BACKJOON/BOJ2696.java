package BACKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2696 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int t = 0; t < T; t++) {
            int num = Integer.parseInt(br.readLine());
            if(num <= 10) {
                st = new StringTokenizer(br.readLine());
                int[] nums = new int[num];
                for(int i = 0; i < num; i++) {
                    nums[i] = Integer.parseInt(st.nextToken());
                }
                solution(nums);
            }
            else {
                int index = 0;
                int[] nums = new int[num];
                st = new StringTokenizer(br.readLine());
                while(index < num) {
                    if(!st.hasMoreTokens()) {
                        st = new StringTokenizer(br.readLine());
                    }
                    nums[index++] = Integer.parseInt(st.nextToken());
                }
                solution(nums);
            }
        }
    }

    public static void solution(int[] nums) {
        int count = (nums.length + 1) / 2;
        System.out.println(count);

        Queue<Integer> q = new PriorityQueue<>();
        List<Integer> temp = new ArrayList<>();
        int c = 0;

        for(int i = 0; i < nums.length; i++) {
            if(i % 2 != 0) {
                q.offer(nums[i]);
                continue;
            }
            q.offer(nums[i]);

            int n = 0;
            int targetN = q.size() / 2;
            while(true) {
                if(n == targetN) {
                    System.out.print(q.peek() + " ");
                    break;
                }
                n++;
                temp.add(q.poll());
            }

            c++;
            if(c % 10 == 0) {
                System.out.println();
            }
            while(!temp.isEmpty()) {
                q.offer(temp.remove(0));
            }
        }
        System.out.println();
    }
}
