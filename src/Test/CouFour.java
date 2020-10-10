package Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class CouFour {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[][] roads = {{"ULSAN", "BUSAN"}, {"DAEJEON", "ULSAN"}, {"DAEJEON", "GWANGJU"}, {"SEOUL", "DAEJEON"}, {"SEOUL", "ULSAN"}, {"DAEJEON", "DAEGU"}, {"GWANGJU", "BUSAN"}, {"DAEGU", "GWANGJU"}, {"DAEGU", "BUSAN"}, {"ULSAN", "DAEGU"}, {"GWANGJU", "YEOSU"},{"BUSAN", "YEOSU"}};
        bw.write(solution("SEOUL", "DAEGU", "YEOSU", roads));
        bw.flush();
        bw.close();
    }

    public static int solution(String depar, String hub, String dest, String[][] roads) {
        HashMap<String, Integer> map = new HashMap<>();
        int cityNum = 0;
        for(int i = 0; i < roads.length; i++) {
            if(!map.containsKey(roads[i][0])) {
                map.put(roads[i][0], cityNum++);
            }
            if(!map.containsKey(roads[i][1])) {
                map.put(roads[i][1], cityNum++);
            }
        }

        if(!map.containsKey(depar)) {
            return 0;
        }
        int d = map.get(depar);
        int h = map.get(hub);
        int target = map.get(dest);

        boolean[][] r = new boolean[cityNum][cityNum];
        for(int i = 0; i < roads.length; i++) {
            r[map.get(roads[i][0])][map.get(roads[i][1])] = true;
        }






        int[] v = new int[cityNum];
        v[d] = 1;

        Queue<Integer> q = new LinkedList<>();
        q.offer(d);
        while(!q.isEmpty()) {
            int temp = q.poll();
            if(temp == target) {
                continue;
            }
            if(temp == h) {
                continue;
            }

            for(int c = 0; c < cityNum; c++) {
                if(!r[temp][c]) {
                    continue;
                }

                // 가는 길이 있음
                v[c] += v[temp];
                q.offer(c);
            }
        }

        int goHub = v[h];

        Arrays.fill(v, 0);
        v[h] = 1;
        q.clear();
        q.offer(h);
        while(!q.isEmpty()) {
            int temp = q.poll();
            if(temp == target) {
                continue;
            }

            for(int c = 0; c < cityNum; c++) {
                if(!r[temp][c]) {
                    continue;
                }

                v[c] += v[temp];
                q.offer(c);
            }
        }

        return (goHub * v[target]);
    }
}
