package Test;

import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.*;

public class Kakao2021Six {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] board = new int[4][4];
        StringTokenizer st;
        for(int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 4; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int r = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        bw.write(solution(board, r, c) + "");
        bw.flush();
        bw.close();
    }

    static int[] dirI = {0, 0, 1, -1};
    static int[] dirJ = {1, -1, 0, 0};
    static int answer = Integer.MAX_VALUE;
    static List<CardIndex> cardList = new ArrayList<>();

    static List<Point> list[];
    static int dist[];
    static boolean check[];
    static int n, v;
    private static final int INF = 200_000_000;

    public static int solution(int[][] board, int r, int c) {

        cursor = new CardIndex(r, c);

        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                if(board[i][j] != 0) {
                    CardIndex card = new CardIndex(i, j);
                    card.index = board[i][j];
                    cardList.add(card);
                }
            }
        }

        Collections.sort(cardList, new Comparator<CardIndex>() {
            @Override
            public int compare(CardIndex o1, CardIndex o2) {
                return o1.index - o2.index;
            }
        });

        boolean[] visit = new boolean[cardList.size() / 2];
        List<Integer> indexList = new ArrayList<>();
        move(0, visit, indexList);

        return answer;
    }

    static CardIndex cursor;
    public static void move(int count, boolean[] visit, List<Integer> list) {
        if(count == visit.length) {
            int c = 0;
            CardIndex prev = cursor;
            for(int i = 0; i < list.size(); i++) {
                int index = list.get(i);
                int moveOne = move(prev, cardList.get(index));
                int moveTwo = move(prev, cardList.get(index));


                move(prev, cardList.get(index));
                move(cardList.get(index), cardList.get(index + 1));
                prev = cardList.get(index + 1);
            }
            answer = Math.min(answer, c);
            return;
        }
        for(int i = 0; i < visit.length; i++) {
            if(!visit[i]) {
                visit[i] = true;
                list.add(i);
                move(count + 1, visit, list);
                list.remove(i);
                visit[i] = false;
            }
        }
    }

    public static int move(CardIndex start, CardIndex end) {
        return 0;
    }
}
class CardIndex {
    int i;
    int j;
    int index;

    CardIndex(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
