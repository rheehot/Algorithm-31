package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ1194 {
    static int n,m;
    static char[][] map;
    static List<String>[][] visit;
    static Queue<MoonNode> q = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visit = new ArrayList[n][m];
        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j = 0; j < m; j++) {
                visit[i][j] = new ArrayList<>();

                char temp = str.charAt(j);
                if(temp == '0') {
                    q.offer(new MoonNode(i, j, "000000"));
                    visit[i][j].add("000000");
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

    static int solution() {
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for(int s = 0; s < size; s++) {
                MoonNode temp = q.poll();
                if(map[temp.i][temp.j] == '1') {
                    return count;
                }

                for(int index = 0; index < 4; index++) {
                    int nextI = temp.i + dirI[index];
                    int nextJ = temp.j + dirJ[index];

                    // 지도 넘어감, 벽
                    if(nextI < 0 || nextI >= n || nextJ < 0 || nextJ >= m || map[nextI][nextJ] == '#') {
                        continue;
                    }
                    // 이미 방문
                    if(visit[nextI][nextJ].contains(temp.keys)) {
                        continue;
                    }

                    // 문
                    if(map[nextI][nextJ] >= 'A' && map[nextI][nextJ] <= 'Z') {
                        int keyIndex = map[nextI][nextJ] - 'A';
                        // 키 없음 -> 갈 수 없음
                        if(temp.keys.charAt(keyIndex) == '0') {
                            continue;
                        }
                    }

                    // 문이여도 키가 있어서 지나갈 수 있음

                    MoonNode next = new MoonNode(nextI, nextJ, temp.keys);

                    // 열쇠
                    if(map[nextI][nextJ] >= 'a' && map[nextI][nextJ] <= 'z') {
                        int keyIndex = map[nextI][nextJ] - 'a';
                        // 없는 열쇠 득템
                        if(next.keys.charAt(keyIndex) == '0') {
                            String tempKeys = next.keys.substring(0, keyIndex);
                            tempKeys += "1";
                            tempKeys += next.keys.substring(keyIndex);
                            next.keys = tempKeys;
                        }
                    }
                    // 빈곳
                    q.offer(next);
                    visit[nextI][nextJ].add(next.keys);
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
    String keys;

    MoonNode(int i, int j, String keys) {
        this.i = i;
        this.j = j;
        this.keys = keys;
    }
}