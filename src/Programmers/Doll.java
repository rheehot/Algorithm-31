package Programmers;

import java.util.Scanner;
import java.util.Stack;

public class Doll {
    public static void main(String[] args) {
         Scanner scan = new Scanner(System.in);
         int N = scan.nextInt();
         int[][] map = new int[N][N];
         for(int i = 0; i < N; i++) {
             for(int j = 0; j < N; j++) {
                 map[i][j] = scan.nextInt();
             }
         }

         int M = scan.nextInt();
         int[] moves = new int[M];
         for(int i = 0; i < M; i++) {
             moves[i] = scan.nextInt();
         }

         System.out.println(solution(map, moves));
    }

    public static int solution(int[][] board, int[] moves) {
        int result = 0;
        Stack<Integer> basket = new Stack<>();
        for(int index = 0; index < moves.length; index++) {
            int j = moves[index] - 1;
            int i = 0;
            while(true){
                if(i >= board.length) {
                    break;
                }

                // 인형이 있는 경우
                if (board[i][j] != 0) {
                    // 바구니에서 연속하는 인형이라면
                    if (basket.isEmpty()) {
                        basket.push(board[i][j]);
                        board[i][j] = 0;
                        break;
                    }
                    if (basket.peek() == board[i][j]) {
                        basket.pop();
                        result += 2;
                    }
                    else {
                        basket.push(board[i][j]);
                    }

                    board[i][j] = 0;
                    break;
                }

                i++;
            }
        }
        return result;
    }
}
