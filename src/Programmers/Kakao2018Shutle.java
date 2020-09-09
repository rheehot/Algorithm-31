package Programmers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Kakao2018Shutle {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int size = Integer.parseInt(br.readLine());
        String[] timetable = new String[size];
        for(int i = 0; i < size; i++) {
            timetable[i] = br.readLine();
        }

        bw.write(solution(n, t, m, timetable));
        bw.flush();
        bw.close();
    }


    public static String solution(int n, int t, int m, String[] timetable) {
       Queue<ShuttleTime> q = new PriorityQueue<>(new Comparator<ShuttleTime>() {
           @Override
           public int compare(ShuttleTime o1, ShuttleTime o2) {
               if(o1.hour == o2.hour) {
                   return o1.minute - o2.minute;
               }
               return o1.hour - o2.hour;
           }
       });

       for(int i = 0; i < timetable.length; i++) {
           int hour = Integer.parseInt(timetable[i].substring(0, 2));
           int minute = Integer.parseInt(timetable[i].substring(3));

           q.offer(new ShuttleTime(hour, minute));
       }

       ShuttleTime shuttle = new ShuttleTime(9, 0);

       int count = 0;
       String answer = "";
       while(n > 0) {
           // 마지막 셔틀
           if(n == 1) {
               // 셔틀 탈 사람이 없음
               if(q.isEmpty()) {
                   answer = stringTime(shuttle);
                   return answer;
               }
               // 셔틀 탈 사람이 있음
               count = 0;
               while(true) {
                   if(q.isEmpty()) {
                       answer = stringTime(shuttle);
                       return answer;
                   }
                   // 한 자리 남음
                   if(count == m - 1) {
                       if(q.peek().hour > shuttle.hour || (q.peek().hour == shuttle.hour && q.peek().minute > shuttle.minute)) {
                           answer = stringTime(shuttle);
                           return answer;
                       }
                       else {
                           ShuttleTime temp = q.poll();
                           if(temp.minute == 0) {
                               temp.minute = 59;
                               temp.hour -= 1;
                               answer = stringTime(temp);
                               return answer;
                           }
                           else {
                               temp.minute -= 1;
                               answer = stringTime(temp);
                               return answer;
                           }
                       }
                   }
                   // 셔틀에 탈 수 없는 사람
                   if(q.peek().hour > shuttle.hour || (q.peek().hour == shuttle.hour && q.peek().minute > shuttle.minute)) {
                       answer = stringTime(shuttle);
                       return answer;
                   }
                   count++;
                   q.poll();
               }
           }
           else {
               // 셔틀에 탈 사람이 없음
               if(q.isEmpty()) {
                   n--;
                   shuttle.minute += t;
                   if(shuttle.minute >= 60) {
                       shuttle.hour += 1;
                       shuttle.minute -=60;
                   }
                   count = 0;
                   continue;
               }
               // 셔틀에 탈 사람이 있음
               if(shuttle.hour > q.peek().hour || (shuttle.hour == q.peek().hour && shuttle.minute >= q.peek().minute)) {
                   // 셔틀이 꽉참
                   if(count >= m) {
                       n--;
                       shuttle.minute += t;
                       if(shuttle.minute >= 60) {
                           shuttle.hour += 1;
                           shuttle.minute -=60;
                       }
                       count = 0;
                       continue;
                   }
                   // 셔틀에 자리 남음
                   count++;
                   q.poll();
                   continue;
               }

               // 셔틀에 탈 사람이 없음
               n--;
               shuttle.minute += t;
               if(shuttle.minute >= 60) {
                   shuttle.hour += 1;
                   shuttle.minute -=60;
               }
               count = 0;
           }
       }

       return answer;
    }

    public static String stringTime(ShuttleTime time) {
        String answer = "";

        answer += time.hour;
        if(answer.length() == 1) {
            answer = "0" + answer;
        }
        answer += ":";

        if((time.minute / 10) == 0) {
            answer += "0";
        }
        answer += time.minute;

        return answer;
    }
}
class ShuttleTime {
    int hour;
    int minute;

    ShuttleTime(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }
}
