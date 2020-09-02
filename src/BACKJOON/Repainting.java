package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Repainting {
    public static int[][] board;
    public static int N;
    public static int M;
    public static int[][] black = {{1, 0, 1, 0, 1, 0, 1, 0}, {0, 1, 0, 1, 0, 1, 0, 1}, {1, 0, 1, 0, 1, 0, 1, 0}, {0, 1, 0, 1, 0, 1, 0, 1}, {1, 0, 1, 0, 1, 0, 1, 0}, {0, 1, 0, 1, 0, 1, 0, 1}, {1, 0, 1, 0, 1, 0, 1, 0}, {0, 1, 0, 1, 0, 1, 0, 1}};
    public static int[][] white = {{0, 1, 0, 1, 0, 1, 0, 1}, {1, 0, 1, 0, 1, 0, 1, 0}, {0, 1, 0, 1, 0, 1, 0, 1}, {1, 0, 1, 0, 1, 0, 1, 0}, {0, 1, 0, 1, 0, 1, 0, 1}, {1, 0, 1, 0, 1, 0, 1, 0}, {0, 1, 0, 1, 0, 1, 0, 1}, {1, 0, 1, 0, 1, 0, 1, 0}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                if(str.charAt(j) == 'B') {
                    board[i][j] = 1;
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for(int i = 0; i <= N - 8; i++) {
            for(int j = 0; j <= M - 8; j++) {
                int blackCount = 0;
                int whiteCount = 0;
                for(int iDiff = 0; iDiff < 8; iDiff++) {
                    for(int jDiff = 0; jDiff < 8; jDiff++) {

                        if(board[i + iDiff][j + jDiff] != black[iDiff][jDiff]) {
                            blackCount++;
                        }
                        if(board[i + iDiff][j + jDiff] != white[iDiff][jDiff]) {
                            whiteCount++;
                        }
                    }
                }

                answer = Math.min(answer, blackCount);
                answer = Math.min(answer, whiteCount);
            }
        }

        bw.write(answer+"");
        bw.flush();
        bw.close();
    }
}
