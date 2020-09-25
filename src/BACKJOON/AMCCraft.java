package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class AMCCraft {
    static int n, k;
    static int[] times;

    // 후행 건물
    static List<Integer>[] list;
    // 선행 건물 갯수
    static int[] preNums;

    static Queue<CraftNode> pq = new PriorityQueue<>(new Comparator<CraftNode>() {
        @Override
        public int compare(CraftNode o1, CraftNode o2) {
            return Long.compare(o1.time, o2.time);
        }
    });
    static int target;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for(int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            times = new int[n + 1];
            list = new ArrayList[n + 1];
            preNums = new int[n + 1];
            for(int index = 1; index <= n; index++) {
                times[index] = Integer.parseInt(st.nextToken());
                list[index] = new ArrayList<>();
            }

            pq.clear();
            for(int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int pre = Integer.parseInt(st.nextToken());
                int post = Integer.parseInt(st.nextToken());

                preNums[post]++;
                list[pre].add(post);
            }

            for(int i = 1; i <= n; i++) {
                if(preNums[i] == 0) {
                    pq.add(new CraftNode(i, times[i]));
                }
            }

            target = Integer.parseInt(br.readLine());
            long answer = craft();

            bw.write(answer + "\n");
        }

        bw.flush();
        bw.close();
    }

    static long craft() {
        long count = 0;

        while(!pq.isEmpty()) {
            count = pq.peek().time;

            while(!pq.isEmpty() && pq.peek().time == count) {
                CraftNode temp = pq.poll();
                if(temp.index == target) {
                    return count;
                }

                judge(temp, count);
            }
        }

        return count;
    }

    static void judge(CraftNode temp, long count) {
        for(int i = 0; i < list[temp.index].size(); i++) {
            int nextNum = list[temp.index].get(i);
            preNums[nextNum]--;
            if(preNums[nextNum] == 0) {
                pq.add(new CraftNode(nextNum, count + times[nextNum]));
            }
        }
    }
}

class CraftNode {
    int index;
    long time;

    CraftNode(int index, long time) {
        this.index = index;
        this.time = time;
    }
}