package Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class CouTwo {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] c1 = {"10/01 23:20:25 30", "10/01 23:25:50 26", "10/01 23:31:00 05", "10/01 23:33:17 24", "10/01 23:50:25 13", "10/01 23:55:45 20", "10/01 23:59:39 03", "10/02 00:10:00 10"};
        bw.write(solution(3, c1) + "");
        //4

        String[] c2 = {"02/28 23:59:00 03", "03/01 00:00:00 02", "03/01 00:05:00 01"};
        bw.write(solution(2, c2) + "");
        //2

        bw.flush();
        bw.close();
    }

    static Queue<Custom> kQ = new PriorityQueue<>(new Comparator<Custom>() {
        @Override
        public int compare(Custom o1, Custom o2) {
            if(o1.day == o2.day) {
                if(o1.time.equals(o2.time)) {
                    return o1.using - o2.using;
                }

                return o1.time.compareTo(o2.time);
            }
            return o1.day - o2.day;
        }
    });
    static Queue<Custom> cQ = new LinkedList<>();

    static Queue<Custom> uQ = new PriorityQueue<>(new Comparator<Custom>() {
        @Override
        public int compare(Custom o1, Custom o2) {
            if(o1.day == o2.day) {
                return o1.time.compareTo(o2.time);
            }
            return o1.day - o2.day;
        }
    });

    static int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static int solution(int n, String[] customs) {
        int[] k2c = new int[n];

        setting(n, customs);

        int max = 0;
        while(!cQ.isEmpty()) {
            // 대기 남아있음
            if(!kQ.isEmpty()) {
                // 작업 비어 있음
                if(uQ.isEmpty()) {
                    // 대기가 사람보다 먼저 있음
                    if(checkTime(kQ.peek(), cQ.peek())) {
                        Custom next = kiosk(cQ.peek(), cQ.peek().using);
                        next.using = kQ.peek().using;
                        k2c[next.using]++;
                        max = Math.max(k2c[next.using], max);
                        uQ.offer(next);
                        kQ.poll();
                        cQ.poll();
                    }
                    // 사람이 먼저 옴
                    else {
                        Custom next = kiosk(kQ.peek(), cQ.peek().using);
                        k2c[next.using]++;
                        max = Math.max(k2c[next.using], max);
                        uQ.offer(next);
                        kQ.poll();
                        cQ.poll();
                    }
                }
                // 작업 있으므로 대기랑 작업이랑 비교
                else {
                    // 대기가 먼저 빔
                    if(checkTime(kQ.peek(), uQ.peek())) {
                        Custom next = kiosk(kQ.peek(), cQ.peek().using);
                        k2c[next.using]++;
                        max = Math.max(k2c[next.using], max);
                        uQ.offer(next);
                        kQ.poll();
                        cQ.poll();
                    }
                    // 작업이 먼저 빔
                    else {
                        Custom next = kiosk(uQ.peek(), cQ.peek().using);
                        k2c[next.using]++;
                        max = Math.max(k2c[next.using], max);
                        uQ.offer(next);
                        uQ.poll();
                        cQ.poll();
                    }
                }
            }
            // 대기 비어있음
            else {
                // 작업 먼저 끝남
                if(checkTime(uQ.peek(), cQ.peek())) {
                    Custom next = kiosk(cQ.peek(), cQ.peek().using);
                    next.using = uQ.peek().using;
                    k2c[next.using]++;
                    max = Math.max(k2c[next.using], max);
                    uQ.offer(next);
                    cQ.poll();
                    uQ.poll();
                }
                // 사람 먼저 끝남
                else {
                    Custom next = kiosk(kQ.peek(), cQ.peek().using);
                    k2c[next.using]++;
                    max = Math.max(k2c[next.using], max);
                    uQ.offer(next);
                    cQ.poll();
                    uQ.poll();
                }
            }
        }

        return max;
    }

    // 키오스크 작업 끝나는거 돌려줌
    public static Custom kiosk(Custom start, int using) {
        String tempTime = start.time;
        int uTime = using;
        int time = Integer.parseInt(tempTime.substring(3, 5));
        time += uTime;

        String nextTime = "";
        int nextDay = start.day;
        if(time >= 60) {
            int hour = Integer.parseInt(tempTime.substring(0, 2));
            hour += 1;
            time -= 60;

            if(hour >= 24) {
                nextDay++;
                hour -= 24;
            }

            if(hour < 10) {
                nextTime += "0";
            }
            nextTime += hour;
            nextTime += ":";
            if(time < 10) {
                nextTime += "0";
            }
            nextTime += time;
            nextTime += tempTime.substring(5);
        }
        else {
            nextTime = tempTime.substring(0, 3);
            if(time < 10) {
                nextTime += "0";
            }
            nextTime += time;
            nextTime += tempTime.substring(5);
        }

        Custom result = new Custom(nextDay, nextTime, start.using);
        return result;
    }

    // 키오스크 시간이 사람 시간보다 작으면 true -> 사용 가능
    public static boolean checkTime(Custom k, Custom c) {
        if(k.day > c.day) {
            return false;
        }
        if(k.day < c.day) {
            return true;
        }
        if(k.time.equals(c.time)) {
            return true;
        }
        int a = k.time.compareTo(c.time);
        return a < 0;
    }

    public static void setting(int n, String[] customs) {
        kQ.clear();
        cQ.clear();

        for(int index = 0; index < n; index++) {
            kQ.offer(new Custom(0, "00:00:00", index));
        }

        String prevDay = "";
        int prevDiff = 0;
        for(int index = 0; index < customs.length; index++) {
            String[] time = customs[index].split(" ");
            if(prevDay.equals("")) {
                prevDay = time[0];
                cQ.offer(new Custom(0, time[1], Integer.parseInt(time[2])));
            }
            else if(prevDay.equals(time[0])){
                cQ.offer(new Custom(prevDiff, time[1], Integer.parseInt(time[2])));
            }
            else {
                if(prevDay.substring(0, 2).equals(time[0].substring(0, 2))) {
                    prevDiff += Integer.parseInt(time[0].substring(3)) - Integer.parseInt(prevDay.substring(3));
                    cQ.offer(new Custom(prevDiff, time[1], Integer.parseInt(time[2])));
                }
                else {
                    int prevD = days[Integer.parseInt(prevDay.substring(0, 2))] - Integer.parseInt(prevDay.substring(3));
                    int nextD = Integer.parseInt(time[0].substring(3));
                    prevDiff += (prevD + nextD);
                    cQ.offer(new Custom(prevDiff, time[1], Integer.parseInt(time[2])));
                }
                prevDay = time[0];
            }
        }
    }
}

class Custom {
    int day;
    String time;
    int using;

    Custom(int day, String time, int using) {
        this.day = day;
        this.time = time;
        this.using = using;
    }
}
