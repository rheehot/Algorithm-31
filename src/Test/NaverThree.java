package Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NaverThree {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] oneEdges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}, {1, 5}, {2, 6}, {3, 7}, {3, 8}, {3, 9}, {4, 10}, {4, 11}, {5, 12}, {5, 13}, {6, 14}, {6, 15}, {6, 16}, {8, 17}, {8, 18}};
        bw.write(solution(19, oneEdges) + "\n");

        int[][] twEdges = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}, {2, 7}, {3, 8}, {3, 9}, {3, 10}, {4, 11}, {4, 12}, {4, 13}};
        bw.write(solution(14, twEdges) + "\n");

        int[][] threeEdges = {{0, 1}, {0, 2}, {1, 3}, {2, 4}, {2, 5}, {2, 6}, {3, 7}, {3, 8}, {3, 9}};
        bw.write(solution(10, threeEdges) + "\n");

        int[][] fourEdges = {{0, 1}, {0, 2}, {1, 3}};
        bw.write(solution(4, fourEdges) + "\n");

        bw.flush();
        bw.close();
    }

    static List<Integer>[] list;
    static int answer = Integer.MAX_VALUE;
    public static int solution(int n, int[][] edges) {
        list = new List[n];
        for(int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i < edges.length; i++) {
            int p = edges[i][0];
            int c = edges[i][1];

            list[p].add(c);
        }

        // 감염된 컴퓨터
        List<Integer> cur = new ArrayList<>();
        cur.add(0);
        choice(cur, 1);

        return answer;
    }

    public static void choice(List<Integer> cur, int count) {

        List<Integer> next = new LinkedList<>();
        for(int i = 0; i < cur.size(); i++) {
            // 현재 감염되어 있는 최하 노드
            int c = cur.get(i);

            // 감염 가능성이 있는 노드
            for(int computer : list[c]) {
                next.add(computer);
            }
        }

        if(next.isEmpty()) {
            answer = Math.min(answer, count);
            return;
        }

        // next는 감염 가능성이 있는 노드
        for(int i = 0; i < next.size(); i++) {
            int temp = next.remove(i);
            choice(next, count + next.size());
            next.add(i, temp);
        }
    }

}
