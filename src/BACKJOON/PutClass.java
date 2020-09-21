package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class PutClass {
    static Queue<PutClassNode> startQ = new PriorityQueue<>(new Comparator<PutClassNode>() {
        @Override
        public int compare(PutClassNode o1, PutClassNode o2) {
            return o1.start - o2.start;
        }
    });
    static Queue<Integer> endQ = new PriorityQueue<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            startQ.offer(new PutClassNode(start, end));
        }

        if(N == 1) {
            bw.write("1");
        }
        else {
            int answer = check();
            bw.write(answer + "");
        }

        bw.flush();
        bw.close();
    }

    public static int check() {
        int count = 0;
        while(!startQ.isEmpty()) {
            PutClassNode temp = startQ.poll();
            if(endQ.isEmpty()) {
                endQ.offer(temp.end);
                count = Math.max(count, endQ.size());
                continue;
            }

            if (temp.start >= endQ.peek()) {
                endQ.poll();
                endQ.offer(temp.end);
            }
            else {
                endQ.offer(temp.end);
                count = Math.max(count, endQ.size());
            }
        }
        return count;
    }

}

class PutClassNode {
    int start;
    int end;

    PutClassNode(int start, int end) {
        this.start = start;
        this.end = end;
    }
}