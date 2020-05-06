package Programmers;

import java.util.ArrayList;
import java.util.Scanner;

public class BannedUser {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        scan.nextLine();
        String[] user_id = new String[n];
        for(int i = 0; i < n; i++) {
            user_id[i] = scan.next();
        }

        n = scan.nextInt();
        scan.nextLine();
        String[] banned_id = new String[n];
        for(int i = 0; i < n; i++) {
            banned_id[i] = scan.next();
        }

        System.out.println(solution(user_id, banned_id));
    }

    static ArrayList<ArrayList> list = new ArrayList<>();

    public static int solution(String[] user_id, String[] banned_id) {
        boolean[] visit = new boolean[user_id.length];
        dfs(user_id, banned_id, visit, 0, 0);

        return list.size();
    }

    public static void dfs(String[] user_id, String[] ban_id, boolean[] visit, int ban_index, int count) {
        // 다 고름
        if (count == ban_id.length) {
            // 고른거 Arraylist에 담아두기
            ArrayList<String> tempBan = new ArrayList<>();
            for (int i = 0; i < visit.length; i++) {
                if (visit[i]) {
                    tempBan.add(user_id[i]);
                }
            }

            // 만약 list가 비어있다면
            if (list.isEmpty()) {
                list.add(tempBan);
            }
            // list가 안 비어있다면
            else {
                int c = 0;
                for (int i = 0; i < list.size(); i++) {
                    ArrayList t = list.get(i);

                    boolean flag = true;
                    for (int j = 0; j < tempBan.size(); j++) {
                        // tempBan 요소가 t랑 안 같음
                        if (!t.contains(tempBan.get(j))) {
                            flag = false;
                            break;
                        }
                    }
                    if (!flag) {
                        c++;
                    }
                }
                if (c == list.size()) {
                    list.add(tempBan);
                }
            }
            return;
        }
        // 다 못 골랐는데 index 넘어감
        if (ban_index >= ban_id.length) {
            return;
        }
        // 해당 index ban_id가 있는지 확인
        String ban = ban_id[ban_index];
        for (int i = 0; i < user_id.length; i++) {
            // 길이가 안 맞으면 매핑 불가
            if (ban.length() != user_id[i].length()) {
                continue;
            }
            if (visit[i]) {
                continue;
            }
            boolean flag = true;
            for (int j = 0; j < ban.length(); j++) {
                if (ban.charAt(j) == '*') {
                    continue;
                }
                if (ban.charAt(j) != user_id[i].charAt(j)) {
                    flag = false;
                }
            }
            if (flag) {
                visit[i] = true;
                dfs(user_id, ban_id, visit, ban_index + 1, count + 1);
                visit[i] = false;
            }
        }
    }
}
