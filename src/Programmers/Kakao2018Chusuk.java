package Programmers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Kakao2018Chusuk {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] lines = new String[n];
        for(int i = 0; i < lines.length; i++) {
            lines[i] = br.readLine();
        }

        bw.write(solution(lines) + "");

        bw.flush();
        bw.close();
    }

    public static int solution(String[] lines) {
        int size = lines.length;
        if(size < 2) {
            return size;
        }

        // startTime 오름차순
        Queue<ChusukTime> trafficQueue = new PriorityQueue<>(new Comparator<ChusukTime>() {
            @Override
            public int compare(ChusukTime o1, ChusukTime o2) {
                if(o1.startHour == o2.startHour) {
                    if(o2.startMinute == o2.startMinute) {
                        return o1.startSecond - o2.startSecond;
                    }
                    return o1.startMinute - o2.startMinute;
                }
                return o1.startHour - o2.startHour;
            }
        });

        // endTime 오름차순
        Queue<ChusukTime> ongoingQueue = new PriorityQueue<>(new Comparator<ChusukTime>() {
            @Override
            public int compare(ChusukTime o1, ChusukTime o2) {
                if(o1.endHour == o2.endHour) {
                    if(o2.endMinute == o2.endMinute) {
                        return o1.endSecond - o2.endSecond;
                    }
                    return o1.endMinute - o2.endMinute;
                }
                return o1.endHour - o2.endHour;
            }
        });

        StringTokenizer st;
        for(int index = 0; index < size; index++) {
            st = new StringTokenizer(lines[index]);
            st.nextToken();

            String[] time = st.nextToken().split(":");

            int hour = Integer.parseInt(time[0]);
            int minute = Integer.parseInt(time[1]);
            int second = (int)(Double.parseDouble(time[2]) * 1000);

            String tStr = st.nextToken();
            int t = (int)(Double.parseDouble(tStr.substring(0, tStr.length() - 1)) * 1000);

            int startHour = hour;
            int startMinute = minute;
            int startSecond = second;
            startSecond -= t;
            startSecond += 1;

            if(startSecond < 0) {
                startMinute--;
                startSecond += 60000;

                if(startMinute < 0) {
                    startHour--;
                    startMinute = 59;
                }
            }
            if(startSecond >= 60000) {
                startMinute++;
                startSecond -= 60000;

                if(startMinute >= 60) {
                    startHour++;
                    startMinute -= 60;
                }
            }

            ChusukTime traffic = new ChusukTime(startHour, startMinute, startSecond);
            traffic.endHour = hour;
            traffic.endMinute = minute;
            traffic.endSecond = second;

            trafficQueue.offer(traffic);
        }

        int answer = 0;

        while(!trafficQueue.isEmpty()) {
            ChusukTime temp = trafficQueue.poll();
            if(ongoingQueue.isEmpty()) {
                ongoingQueue.offer(temp);
                continue;
            }

            // temp start랑 ongoingQ peek end랑 비교
            // 1초동안 트랙픽 양이니까 start-1초까지는 봐줘야댐
            int diffHour = temp.startHour;
            int diffMinute = temp.startMinute;
            int diffSecond = temp.startSecond;
            diffSecond -= 1000;
            if(diffSecond < 0) {
                diffMinute--;
                diffSecond += 60000;

                if(diffMinute < 0) {
                    diffHour--;
                    diffMinute = 59;
                }
            }

            ChusukTime peekTime = ongoingQueue.peek();
            while(!ongoingQueue.isEmpty() && pollTime(diffHour, diffMinute, diffSecond, peekTime)) {
                ongoingQueue.poll();
                peekTime = ongoingQueue.peek();
            }

            ongoingQueue.offer(temp);
            answer = Math.max(answer, ongoingQueue.size());
        }

        return answer;
    }

    // end가 start보다 이전이면 true
    public static boolean pollTime(int diffHour, int diffMinute, int diffSecond, ChusukTime end) {
        if(end.endHour > diffHour) {
            return false;
        }
        if(end.endHour < diffHour) {
            return true;
        }

        if(end.endMinute > diffMinute) {
            return false;
        }
        if(end.endMinute < diffMinute) {
            return true;
        }

        if(end.endSecond > diffSecond) {
            return false;
        }
        else {
            return true;
        }
    }
}
class ChusukTime {
    int startHour;
    int startMinute;
    int startSecond;

    int endHour;
    int endMinute;
    int endSecond;

    ChusukTime(int startHour, int startMinute, int startSecond) {
        this.startHour = startHour;
        this.startMinute = startMinute;
        this.startSecond = startSecond;
    }
}