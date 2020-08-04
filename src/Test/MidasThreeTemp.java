package Test;

import java.util.*;

public class MidasThreeTemp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt();
        int[][] board = new int[num][num];
        for(int i = 0; i < num; i++) {
            for(int j = 0; j < num; j++) {
                board[i][j] = scan.nextInt();
            }
        }

        System.out.println(solution(board));
    }

    public static int[] dirI = {0, 0, -1, 1};
    public static int[] dirJ = {1, -1, 0, 0};
    public static int answer = 0;

    public static int solution(int[][] board) {
        for(int i = 1; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {

                int[][] map = new int[board.length][board.length];
                for(int row = 0; row < map.length; row++) {
                    for(int col = 0; col < map.length; col++) {
                        map[row][col] = board[row][col];
                    }
                }

                map[i][j] = -1;

                int result = candy(gravity(map));

                System.out.println(i + " " + j + " "+ result);

                if(answer < result) {
                    answer = result;
                }
            }
        }

        return answer + 1;
    }

    // 땅으로 내리기
    public static int[][] gravity(int[][] board) {
        for(int i = board.length - 1; i >= 0; i--) {
            for(int j = 0; j < board.length; j++) {
                if (board[i][j] < 0) {
                    for(int k = i - 1; k >= 0; k--) {
                        if(board[k][j] > 0) {
                            board[i][j] = board[k][j];
                            board[k][j] = -1;
                            break;
                        }
                    }
                }
            }
        }
        return board;
    }

    public static boolean[][] visit;
    public static ArrayList<Candy> rowList = new ArrayList<>();
    public static ArrayList<Candy> colList = new ArrayList<>();
    public static int candy(int[][] board) {
        int result = 0;
        visit = new boolean[board.length][board.length];
        while(true) {
            boolean flag = true;
            for(int i = 0; i < visit.length; i++) {
                Arrays.fill(visit[i], false);
            }
            for(int i = 0; i < board.length; i++) {
                for(int j = 0; j < board.length; j++) {
                    if(!visit[i][j] && board[i][j] > 0) {
                        board = bfs(i, j, board);
                    }

                    if(rowList.size() >= 3) {
                        flag = false;
                        for(Candy c : rowList) {
                            if (board[c.i][c.j] < 0) {
                                continue;
                            }
                            result++;
                            board[c.i][c.j] = -1;
                        }
                    }

                    if(colList.size() >= 3) {
                        flag = false;
                        for(Candy c : colList) {
                            if(board[c.i][c.j] < 0) {
                                continue;
                            }
                            result++;
                            board[c.i][c.j] = -1;
                        }
                    }
                    rowList.clear();
                    colList.clear();
                }
            }

            if(flag) {
                break;
            }
            board = gravity(board);
        }

        return result;
    }

    public static int[][] bfs(int i, int j, int[][] board) {

        Queue<Candy> q = new LinkedList<>();

        visit[i][j] = true;
        int temp = board[i][j];

        q.offer(new Candy(i, j));
        rowList.add(new Candy(i, j));

        while (!q.isEmpty()) {

            Candy c = q.poll();
            int row = c.i;
            int col = c.j;

            for (int index = 0; index < 2; index++) {
                int nI = row + dirI[index];
                int nJ = col + dirJ[index];

                if (isBoundary(nI, nJ, board.length) && !visit[nI][nJ] && board[nI][nJ] == temp) {
                    rowList.add(new Candy(nI, nJ));
                    q.offer(new Candy(nI, nJ));
                    visit[nI][nJ] = true;
                }
            }
        }

        q.clear();
        q.offer(new Candy(i, j));
        colList.add(new Candy(i, j));

        while (!q.isEmpty()) {

            Candy c = q.poll();
            int row = c.i;
            int col = c.j;

            for (int index = 2; index < 4; index++) {
                int nI = row + dirI[index];
                int nJ = col + dirJ[index];

                if (isBoundary(nI, nJ, board.length) && !visit[nI][nJ] && board[nI][nJ] == temp) {
                    colList.add(new Candy(nI, nJ));
                    q.offer(new Candy(nI, nJ));
                    visit[nI][nJ] = true;
                }
            }
        }

        return board;
    }

    public static boolean isBoundary(int i, int j, int len) {
        return(i >= 0 && i < len) && (j >= 0 && j < len);
    }
}

class Candy {
    int i;
    int j;
    Candy(int i, int j) {
        this.i = i;
        this.j = j;
    }
}