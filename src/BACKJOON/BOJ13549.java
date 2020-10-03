package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ13549 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Queue<SubinNode> q = new PriorityQueue<>(new Comparator<SubinNode>() {
            @Override
            public int compare(SubinNode o1, SubinNode o2) {
                return o1.count - o2.count;
            }
        });
        q.offer(new SubinNode(start, 0));

        int[] visited = new int[100001];
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[start] = 0;
        while (!q.isEmpty()) {
            SubinNode temp = q.poll();
            if(temp.index == end) {
                bw.write(temp.count + "");
                break;
            }

            if(temp.index * 2 <= 100000 && visited[temp.index * 2] > temp.count) {
                visited[temp.index * 2] = temp.count;
                q.offer(new SubinNode(temp.index * 2, temp.count));
            }
            if(temp.index - 1 >= 0 && visited[temp.index - 1] > temp.count + 1) {
                visited[temp.index - 1] = temp.count + 1;
                q.offer(new SubinNode(temp.index - 1, temp.count + 1));
            }
            if(temp.index + 1 <= 100000 && visited[temp.index + 1] > temp.count + 1) {
                visited[temp.index + 1] = temp.count + 1;
                q.offer(new SubinNode(temp.index + 1, temp.count + 1));
            }
        }


        bw.flush();
        bw.close();
    }
}

class SubinNode {
    int index;
    int count;

    SubinNode(int index, int count) {
        this.index = index;
        this.count = count;
    }
}