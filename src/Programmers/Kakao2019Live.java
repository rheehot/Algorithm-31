package Programmers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Kakao2019Live {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] food_times = new int[n];
        for(int i = 0; i < n; i++) {
            food_times[i] = Integer.parseInt(br.readLine());
        }
        long k = Long.parseLong(br.readLine());

        bw.flush();
        bw.close();
    }

    public static int solution(int[] food_times, long k) {

        Comparator<LiveIndex> comTime = new Comparator<LiveIndex>() {
            @Override
            public int compare(LiveIndex o1, LiveIndex o2) {
                return o1.time - o2.time;
            }
        };

        Comparator<LiveIndex> comIndex = new Comparator<LiveIndex>() {
            @Override
            public int compare(LiveIndex o1, LiveIndex o2) {
                return o1.index - o2.index;
            }
        };

        List<LiveIndex> list = new ArrayList<>();
        for(int i = 0; i < food_times.length; i++) {
            list.add(new LiveIndex(i + 1, food_times[i]));
        }

        list.sort(comTime);

        long preTime = 0;
        int i = 0;
        int n = food_times.length;
        for(LiveIndex l : list) {
            long diff = l.time - preTime;

            if(diff != 0) {
                long spend = diff * n;
                if(spend <= k) {
                    k -= spend;
                    preTime = l.time;
                }
                else {
                    k %= n;
                    list.subList(i, food_times.length).sort(comIndex);
                    return list.get(i + (int)k).index;
                }
            }
            i++;
            n--;
        }

        return -1;
    }

}
class LiveIndex {
    int index;
    int time;

    LiveIndex(int index, int time) {
        this.index = index;
        this.time = time;
    }
}
