package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class TruckBus {
    class Truck {
        int weight;
        int entry;

        Truck(int weight, int entry) {
            this.weight = weight;
            this.entry = entry;
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> waiting = new LinkedList<>();
        Queue<Truck> bridge = new LinkedList<>();

        for(int i = 0; i < truck_weights.length; i++) {
            waiting.offer(new Truck(truck_weights[i], 0));
        }

        int time = 0;
        int totalWeight = 0;
        while(!waiting.isEmpty() || !bridge.isEmpty()) {
            time++;
            // 다리 위에 트럭이 있다면
            if(!bridge.isEmpty()) {
                Truck t = bridge.peek();
                // 다리 위 트럭의 진입 시간과 현재 시간을 비교해서 다리 길이보다 크거나 작다면 끝에 도착한 것이므로 제거
                if (time - t.entry >= bridge_length) {
                    totalWeight -= t.weight;
                    bridge.poll();
                }
            }

            if(!waiting.isEmpty()) {
                if(totalWeight + waiting.peek().weight <= weight) {
                    Truck t = waiting.poll();
                    totalWeight += t.weight;

                    bridge.offer(new Truck(t.weight, time));
                }
            }
        }

        return time;
    }

}
