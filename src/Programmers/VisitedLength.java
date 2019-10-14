package src.Programmers;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/49994?language=java
 */

import java.util.*;

class Dir {
    boolean left;
    boolean right;
    boolean up;
    boolean down;

    Dir() {
        this.left = false;
        this.right = false;
        this.up = false;
        this.down = false;
    }
}

public class VisitedLength {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String dirs = scan.next();
        System.out.print(solution(dirs));
    }

    static int solution(String dirs) {
        int result = 0;

        Dir[][] map = new Dir[11][];
        for (int i = 0; i < 11; i++) {
            map[i] = new Dir[11];
        }

        for(int i = 0; i < 11; i++) {
            for(int j = 0; j < 11; j++) {
                map[i][j] = new Dir();
            }
        }

        int row = 5;
        int col = 5;

        for(int i = 0; i < dirs.length(); i++) {
            char dirItem = dirs.charAt(i);

            switch (dirItem) {
                case 'U':
                    if (row - 1 >= 0) {
                        if(!map[row][col].up) {
                            result++;
                            map[row][col].up = true;
                            map[row - 1][col].down = true;
                        }

                        row--;
                    }
                    break;
                case 'D':
                    if (row + 1 <= 10) {
                        if(!map[row][col].down) {
                            result++;
                            map[row][col].down = true;
                            map[row + 1][col].up = true;
                        }

                        row++;
                    }
                    break;
                case 'L':
                    if (col - 1 >= 0) {
                        if(!map[row][col].left) {
                            result++;
                            map[row][col].left = true;
                            map[row][col - 1].right = true;
                        }

                        col--;
                    }
                    break;
                case 'R':
                    if (col + 1 <= 10) {
                        if(!map[row][col].right) {
                            result++;
                            map[row][col].right = true;
                            map[row][col + 1].left = true;
                        }

                        col++;
                    }
                    break;
            }
        }

        return result;
    }

}