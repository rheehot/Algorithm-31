package Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class EbayOne {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int s = scan.nextInt();
        int[][] simulation_data = new int[s][2];
        for(int i = 0; i < s; i++) {
            simulation_data[i][0] = scan.nextInt();
            simulation_data[i][1] = scan.nextInt();
        }

        System.out.print(solution(N, simulation_data));
    }

    public static int solution(int N, int[][] simulation_data) {
        int sum = 0;

        Queue<Integer> q = new LinkedList<>();

        int index = 0;
        int curTime = 0;

        while(index < simulation_data.length) {
            if(q.isEmpty() && curTime == simulation_data[index][0]) {
                q.offer(simulation_data[index][1] - 1);
                index++;
                curTime++;
                continue;
            }

            int len = q.size();
            for(int s = 0; s < len; s++) {
                int temp = q.poll();
                // 고객 빠져나감
                if(temp == 0) {
                    if(curTime >= simulation_data[index][0]) {
                        sum += (curTime - simulation_data[index][0]);
                        q.offer(simulation_data[index][1] - 1);
                        index++;

                        if(index == simulation_data.length) {
                            return sum;
                        }
                    }
                    continue;
                }

                q.offer(temp - 1);
            }

            if(len < N && curTime >= simulation_data[index][0]) {
                sum += (curTime - simulation_data[index][0]);
                q.offer(simulation_data[index][1] - 1);
                index++;
            }

            curTime++;
        }

        return sum;
    }
}
