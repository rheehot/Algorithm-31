package Programmers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

// 13:50 - 14:08
public class Kakao2019Chat {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] record = new String[N];
        for(int i = 0; i < N; i++) {
            record[i] = br.readLine();
        }

        String[] answer = solution(record);
        for(int i = 0; i < answer.length; i++) {
            bw.write(answer[i] +"\n");
        }

        bw.flush();
        bw.close();
    }

    public static String[] solution(String[] record) {
        HashMap<String, String> map = new HashMap<>();
        List<ChatIndex> list = new ArrayList<>();

        StringTokenizer st;
        for(int i = 0; i < record.length; i++) {
            st = new StringTokenizer(record[i]);

            String target = st.nextToken();
            String userId = st.nextToken();
            switch (target) {
                case "Enter":
                    list.add(new ChatIndex(userId, "님이 들어왔습니다."));
                    if(map.containsKey(userId)) {
                        map.remove(userId);
                        map.put(userId, st.nextToken());
                    }
                    else {
                        map.put(userId, st.nextToken());
                    }
                    break;
                case "Leave":
                    list.add(new ChatIndex(userId, "님이 나갔습니다."));
                    break;
                case "Change":
                    map.remove(userId);
                    map.put(userId, st.nextToken());
                    break;
            }
        }

        String[] answer = new String[list.size()];

        int size = list.size();
        for(int s = 0; s < size; s++) {
            ChatIndex chat = list.get(s);

            String a = "";
            a += map.get(chat.userId);
            a += chat.str;

            answer[s] = a;
        }

        return answer;
    }
}
class ChatIndex {
    String userId;
    String str;

    ChatIndex(String userId, String str) {
        this.userId = userId;
        this.str = str;
    }
}