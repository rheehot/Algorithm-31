package Programmers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Kakao2018Block {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        String[] board = new String[m];
        for(int i = 0; i < m; i++) {
            board[i] = br.readLine();
        }

        bw.write(solution(m, n, board) + "");
        bw.flush();
        bw.close();
    }

    public static int solution(int m, int n, String[] board) {
        char[][] map = new char[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }

        int answer = 0;
        while(true) {
            int count = judge(map, m, n);
            if(count <= 0) {
                break;
            }
            answer += count;
        }
        return answer;
    }

    public static int judge(char[][] map, int m, int n) {
        boolean[][] visit = new boolean[m][n];
        int count = 0;
        for(int i = 0; i < m - 1; i++) {
            for(int j = 0; j < n - 1; j++) {
                if(map[i][j] != ' ' && map[i][j] == map[i + 1][j] && map[i][j] == map[i][j + 1] && map[i][j] == map[i + 1][j + 1]) {
                    if(!visit[i][j]) {
                        count++;
                        visit[i][j] = true;
                    }
                    if(!visit[i + 1][j]) {
                        count++;
                        visit[i + 1][j] = true;
                    }
                    if(!visit[i][j + 1]) {
                        count++;
                        visit[i][j + 1] = true;
                    }
                    if(!visit[i + 1][j + 1]) {
                        count++;
                        visit[i + 1][j + 1] = true;
                    }
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(visit[i][j]) {
                    map[i][j] = ' ';
                }
            }
        }

        for(int j = 0; j < n; j++) {
            int index = m - 1;
            while(index >= 0) {
                if(map[index][j] == ' ') {
                    int tempIndex = index - 1;
                    while(tempIndex >= 0) {
                        if(map[tempIndex][j] != ' ') {
                            map[index][j] = map[tempIndex][j];
                            map[tempIndex][j] = ' ';
                            break;
                        }
                        tempIndex--;
                    }
                }
                index--;
            }
        }

        return count;
    }

}
