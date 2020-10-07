package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ15922 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Queue<AhNode> q = new PriorityQueue<>(new Comparator<AhNode>() {
            @Override
            public int compare(AhNode o1, AhNode o2) {
                if(o1.x == o2.x) {

                    return Long.compare(o1.y, o2.y);
                }
                return Long.compare(o1.x, o2.x);
            }
        });
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            q.offer(new AhNode(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken())));
        }

        long len = 0;

        long prevX = 0;
        long prevY = 0;

        AhNode first = q.poll();
        prevX = first.x;
        prevY = first.y;

        while(!q.isEmpty()) {
            AhNode temp = q.poll();

            if(temp.x > prevY) {
                len += (prevY - prevX);

                prevX = temp.x;
                prevY = temp.y;
            }

            prevY = Math.max(prevY, temp.y);
        }

        len += (prevY - prevX);
        bw.write(len + "");
        bw.flush();
        bw.close();
    }
}

class AhNode {
    long x;
    long y;

    AhNode(long x, long y) {
        this.x = x;
        this.y = y;
    }
}
