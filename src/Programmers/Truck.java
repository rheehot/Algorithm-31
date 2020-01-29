package src.Programmers;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/42583?language=java
 */

import java.util.*;
public class Truck {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int bridge_length = scan.nextInt();
        int weight = scan.nextInt();

        int num = scan.nextInt();
        int[] truck_weights = new int[num];
        for(int i = 0; i < num; i++) {
            truck_weights[i] = scan.nextInt();
        }

        System.out.print(solution(bridge_length, weight, truck_weights));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int totalWeight = 0;
        int index = 0;
        Queue<TruckPoint> q = new LinkedList<>();

        time++;
        totalWeight += truck_weights[index];
        q.add(new TruckPoint(truck_weights[index], 1));
        index++;

        while(!q.isEmpty()) {
            if(q.peek().point == bridge_length) {
                totalWeight -= q.peek().weight;
                q.remove();
            }

            time++;

            if (index >= truck_weights.length) {
                continue;
            }
            if (totalWeight + truck_weights[index] > weight) {
                continue;
            }

            totalWeight += truck_weights[index];
            q.add(new TruckPoint(truck_weights[index], 1));
        }

        return time;
    }
}

class TruckPoint {
    int weight;
    int point;

    TruckPoint(int weight, int point) {
        this.weight = weight;
        this.point = point;
    }
}
