package Programmers;

import java.util.*;

public class FourBlocks {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int m = scan.nextInt();
        int n = scan.nextInt();

        scan.nextLine();

        String[] board = new String[m];
        for(int i = 0; i < m; i++) {
            board[i] = scan.nextLine();
        }

        System.out.println(solution(m, n, board));
    }

    public static int answer = 0;
    public static char[][] map;

    public static int solution(int m, int n, String[] board) {
          map = new char[m][n];

          for(int i = 0; i < m; i++) {
              String temp = board[i];
              for(int j = 0; j < n; j++) {
                  map[i][j] = temp.charAt(j);
              }
          }

          play(m, n);

          return answer;
    }

    public static void play(int m, int n) {

        boolean[][] visit = new boolean[m][n];
        int a = 0;

        for(int i = 0; i < m - 1; i++) {
            for(int j = 0; j < n - 1; j++) {
                if(map[i][j] != ' ' && map[i][j] == map[i][j + 1] && map[i][j] == map[i + 1][j] && map[i][j] ==  map[i + 1][j + 1]) {
                    if(!visit[i][j]) {
                        visit[i][j] = true;
                        a++;
                    }
                    if(!visit[i][j + 1]) {
                        visit[i][j + 1] = true;
                        a++;
                    }
                    if(!visit[i + 1][j]) {
                        visit[i + 1][j] = true;
                        a++;
                    }
                    if(!visit[i + 1][j + 1]) {
                        visit[i + 1][j + 1] = true;
                        a++;
                    }
                }
            }
        }

        if(a == 0) {
            return;
        }
        else {
            answer += a;

            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(visit[i][j]) {
                        map[i][j] = ' ';
                    }
                }
            }

            move(m, n);
            play(m, n);
        }
    }

    public static void move(int m, int n) {
        for(int j = 0; j < n; j++) {
            for(int i = m - 1; i >= 0; i--) {
                if(map[i][j] == ' ') {

                    int tempI = i - 1;
                    while(tempI >= 0) {
                        if(map[tempI][j] != ' ') {
                            map[i][j] = map[tempI][j];
                            map[tempI][j] = ' ';
                            break;
                        }

                        tempI--;
                    }

                }
            }
        }
    }
}
