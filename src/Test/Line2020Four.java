package Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Line2020Four {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] maze = {{0, 1, 0, 0, 0, 0}, {0, 1, 0, 1, 1, 0}, {0, 1, 0, 0, 1, 0}, {0, 1, 1, 1, 1, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 0, 1, 1, 0}};
        bw.write(solution(maze) + "");

        bw.flush();
        bw.close();
    }

    static int userI = 1;
    static int userJ = 1;

    static int[] dirI = {0, -1, 0, 1, 0};
    static int[] dirJ = {0, 0, 1, 0, -1};

    static int[][] map;
    public static int solution(int[][] maze) {

        int n = maze.length;
        map = new int[n + 2][n + 2];
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map.length; j++) {
                if(i == 0 || i == map.length - 1 || j == 0 || j == map.length - 1) {
                    map[i][j] = 1;
                }
                else {
                    map[i][j] = maze[i - 1][j - 1];
                }
            }
        }

        int userDir = 0;
        if(maze[0][1] == 1) {
            userDir = 3;
        }
        else if(maze[1][0] == 1) {
            userDir = 2;
        }

        int answer = 0;

        while(true) {
            if(userI == n && userJ == n) {
                break;
            }

            answer += move(userDir);

            switch (userDir) {
                case 1:
                    if(map[userI][userJ - 1] == 0) {
                        userDir = 4;
                    }
                    else if(map[userI][userJ + 1] == 0){
                        userDir = 2;
                    }
                    else {
                        userDir = 3;
                    }
                    break;
                case 2:
                    if(map[userI - 1][userJ] == 0) {
                        userDir = 1;
                    }
                    else if(map[userI + 1][userJ] == 0) {
                        userDir = 3;
                    }
                    else {
                        userDir = 4;
                    }
                    break;
                case 3:
                    if(map[userI][userJ + 1] == 0) {
                        userDir = 2;
                    }
                    else if(map[userI][userJ - 1] == 0) {
                        userDir = 4;
                    }
                    else {
                        userDir = 1;
                    }
                    break;
                case 4:
                    if(map[userI + 1][userJ] == 0) {
                        userDir = 3;
                    }
                    else if(map[userI - 1][userJ] == 0) {
                        userDir = 1;
                    }
                    else {
                        userDir = 2;
                    }
                    break;
            }
        }

        return answer;
    }

    public static int move(int userDir) {
        int count = 0;

        while(true) {
            int nextI = userI + dirI[userDir];
            int nextJ = userJ + dirJ[userDir];

            if(map[nextI][nextJ] == 1) {
                break;
            }

            userI = nextI;
            userJ = nextJ;
            count++;

            switch(userDir) {
                case 1:
                    if(map[userI][userJ - 1] == 0) {
                        return count;
                    }
                    break;
                case 2:
                    if(map[userI - 1][userJ] == 0) {
                        return count;
                    }
                    break;
                case 3:
                    if(map[userI][userJ + 1] == 0) {
                        return count;
                    }
                    break;
                case 4:
                    if(map[userI + 1][userJ] == 0) {
                        return count;
                    }
                    break;
            }
        }
        return count;
    }
}
