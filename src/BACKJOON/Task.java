package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Task {
    static Queue<TaskNode> pq = new PriorityQueue<>(new Comparator<TaskNode>() {
        @Override
        public int compare(TaskNode o1, TaskNode o2) {
            return o1.time - o2.time;
        }
    });
    // ArrayList에 후행 작업 담고 있음
    static ArrayList<Integer>[] nextList;
    // 끝나야하는 선행 작업의 갯수
    static int[] preTaskNum;
    // 일을 끝내는데 걸리는 시간
    static int[] taskTime;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        nextList = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            nextList[i] = new ArrayList<>();
        }
        preTaskNum = new int[N + 1];
        taskTime = new int[N + 1];

        StringTokenizer st;
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int preNum = Integer.parseInt(st.nextToken());
            taskTime[i] = time;

            if(preNum == 0) {
                pq.offer(new TaskNode(i, time));
                continue;
            }

            preTaskNum[i] = preNum;
            for(int j = 0; j < preNum; j++) {
                nextList[Integer.parseInt(st.nextToken())].add(i);
            }
        }

        int answer = solution();

        bw.write(answer + "");
        bw.flush();
        bw.close();
    }

    static int solution() {
        int second = 0;
        while(!pq.isEmpty()) {
            // 빨리 끝나는 작업
            second = pq.peek().time;
            while(!pq.isEmpty() && pq.peek().time == second) {
                judge(pq.poll(), second);
            }
        }

        return second;
    }

    static void judge(TaskNode temp, int second) {
        for(int i = 0; i < nextList[temp.taskIndex].size(); i++) {
            // 후행 작업 가능한 index
            int nextNum = nextList[temp.taskIndex].get(i);
            preTaskNum[nextNum]--;
            // 후행 작업할 수 있음
            if(preTaskNum[nextNum] == 0) {
                pq.add(new TaskNode(nextNum, second + taskTime[nextNum]));
            }
        }
    }
}

class TaskNode {
    int taskIndex;
    int time;

    TaskNode(int taskIndex, int time) {
        this.taskIndex = taskIndex;
        this.time = time;
    }
}
