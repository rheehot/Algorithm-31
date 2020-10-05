package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1194 {
    static int n, m;
    static char[][] map;
    static boolean[][][] visit;
    static Queue<MoonNode> q = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visit = new boolean[n][m][65];

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j = 0; j < m; j++) {
                char temp = str.charAt(j);

                if(temp == '0') {
                    q.offer(new MoonNode(i, j, 0));
                    visit[i][j][0] = true;
                    continue;
                }

                map[i][j] = temp;
            }
        }
        bw.write(solution() + "");
        bw.flush();
        bw.close();
    }

    static int[] dirI = {0, 0, 1, -1};
    static int[] dirJ = {1, -1, 0, 0};

    public static int solution() {
        int count = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int s = 0; s < size; s++) {
                MoonNode temp = q.poll();
                // 탈출
                if(map[temp.i][temp.j] == '1') {
                    return count;
                }

                for(int index = 0; index < 4; index++) {
                    int nextI = temp.i + dirI[index];
                    int nextJ = temp.j + dirJ[index];

                    // 지도 넘어감, 벽, 이미 방문
                    if(nextI < 0 || nextI >= n || nextJ < 0|| nextJ >= m || map[nextI][nextJ] == '#' || visit[nextI][nextJ][temp.key]) {
                        continue;
                    }

                    // 문
                    if(map[nextI][nextJ] >= 'A' && map[nextI][nextJ] <= 'F') {
                        int indexNum = map[nextI][nextJ] - 'A';

                        // 열쇠 없음
                        if((temp.key & (1 << indexNum)) == 0) {
                            continue;
                        }
                    }

                    MoonNode next = new MoonNode(nextI, nextJ, temp.key);
                    // 열쇠
                    if (map[nextI][nextJ] >= 'a' && map[nextI][nextJ] <= 'f') {
                        int indexNum = map[nextI][nextJ] - 'a';

                        next.key = next.key | 1 << indexNum;
                    }

                    // 빈곳

                    visit[nextI][nextJ][next.key] = true;
                    q.offer(next);
                }
            }
            count++;
        }
        return -1;
    }
}

class MoonNode {
    int i;
    int j;
    int key;

    MoonNode(int i, int j, int key) {
        this.i = i;
        this.j = j;
        this.key = key;
    }
}