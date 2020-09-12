package Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Kakao2021Five {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String play_time = br.readLine();
        String adv_time = br.readLine();

        int N = Integer.parseInt(br.readLine());
        String[] logs = new String[N];
        for(int i = 0; i < N; i++) {
            logs[i] = br.readLine();
        }

        solution(play_time, adv_time, logs);


        bw.flush();
        bw.close();
    }

    static TimeIndex play;
    static TimeIndex adv;
    static Queue<TimeIndex> startQueue;
    static Queue<TimeIndex> endQueue;
    public static String solution(String play_time, String adv_time, String[] logs) {
        if(play_time.equals(adv_time)) {
            return "00:00:00";
        }

        play = makeTime(play_time);
        adv = makeTime(adv_time);

        Arrays.sort(logs);

        startQueue = new PriorityQueue<>(new Comparator<TimeIndex>() {
            @Override
            public int compare(TimeIndex o1, TimeIndex o2) {
                if(o1.hour == o2.hour) {
                    if(o1.minute == o2.minute) {
                        return o1.second - o2.second;
                    }
                    return o1.minute - o2.minute;
                }
                return o1.hour - o2.hour;
            }
        });

        endQueue = new PriorityQueue<>(new Comparator<TimeIndex>() {
            @Override
            public int compare(TimeIndex o1, TimeIndex o2) {
                if(o1.hour == o2.hour) {
                    if(o1.minute == o2.minute) {
                        return o1.second - o2.second;
                    }
                    return o1.minute - o2.minute;
                }
                return o1.hour - o2.hour;
            }
        });

        for(int i = 0; i < logs.length; i++) {
            String[] times = logs[i].split("-");
            startQueue.offer(makeTime(times[0]));
            endQueue.offer(makeTime(times[1]));
        }

        while(!endQueue.isEmpty()) {
            TimeIndex temp = startQueue.poll();

        }

        String answer = "";
        return answer;
    }

    public static TimeIndex makeTime(String time) {
        String[] timeArr = time.split(":");
        return (new TimeIndex(Integer.parseInt(timeArr[0]), Integer.parseInt(timeArr[1]), Integer.parseInt(timeArr[2])));
    }
}

class TimeIndex {
    int hour;
    int minute;
    int second;

    TimeIndex(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
}