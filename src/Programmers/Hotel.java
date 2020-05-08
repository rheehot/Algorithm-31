package Programmers;

import java.util.ArrayList;
import java.util.HashMap;

public class Hotel {

    public long[] solution(long k, long[] room_number) {

        HashMap<Long, Long> map = new HashMap<>();
        long[] answer = new long[room_number.length];

        for(int i = 0; i < room_number.length; i++) {
            long t = room_number[i];
            if (!map.containsKey(t)) {
                map.put(room_number[i], room_number[i] + 1);
                answer[i] = room_number[i];
            }
            else {
                ArrayList<Long> list=new ArrayList();
                while(map.containsKey(t)) {
                    list.add(t);
                    t=map.get(t);
                }
                answer[i]=t;
                list.add(t);
                for(long l:list) {
                    map.put(l,t+1);
                }
            }
        }
        return answer;
    }

}
