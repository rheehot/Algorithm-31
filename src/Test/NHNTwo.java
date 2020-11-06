package Test;

import java.util.Arrays;

public class NHNTwo {
    public static void main(String[] args) throws Exception {
//        int[][] blocks = {{6, 2, 11, 0, 3, 5}, {6, 3, 0, 9, 0, 5}};
//        solution(2, 6, blocks);

        int[][] b = {{6, 12, 0, 2, 8, 4, 0, 7, 3, 6}, {6, 1, 3, 0, 2, 8, 0, 0, 13, 8}, {6, 3, 0,10,6, 5,7, 0, 0, 3}};
        solution(3, 10, b);
    }

    static int answer = 0;
    static int[] map;
    public static void solution(int day, int width, int[][] blocks) {
        answer = 0;
        map = new int[width];
        for(int i = 0; i < day; i++) {
            for(int j = 0; j < width; j++) {
                map[j] += blocks[i][j];
            }
            siment(width);
        }

        System.out.println(answer);
    }

    public static void siment(int width) {
        int max = 0;
        int maxIndex = 0;
        for(int i = 1; i < width - 1; i++) {
            if(max < map[i]) {
                max = map[i];
                maxIndex = i;
            }
        }

        if(maxIndex != 0) {
            left(max, maxIndex);
        }
        if(maxIndex != width - 1) {
            right(max, maxIndex);
        }

        System.out.print(answer + ":");
        for(int i = 0; i < map.length; i++) {
            System.out.print(map[i] + " ");
        }
        System.out.println();
    }
    public static void right(int max, int maxIndex) {
        int[] r = new int [map.length - maxIndex - 1];
        for(int i = 0; i < r.length; i++) {
            r[i] = map[maxIndex + i + 1];
        }
        Arrays.sort(r);

        int rIndex = r.length - 1;
        int mIndex = maxIndex;
        for(int i = maxIndex + 1; i < map.length; i++) {
            // 최대값
            if(map[i] == r[rIndex]) {
                for(int j = i - 1; j > mIndex; j--) {
                    answer += r[rIndex] - map[j];
                    map[j] = r[rIndex];
                }

                rIndex--;
                mIndex = i;
            }
        }
    }

    public static void left(int max, int maxIndex) {
        int[] l = new int[maxIndex];
        for(int i = 0; i < l.length; i++) {
            l[i] = map[i];
        }
        Arrays.sort(l);

        int lIndex = l.length - 1;
        int mIndex = maxIndex;
        for(int i = maxIndex - 1; i >= 0; i--) {
            if(map[i] == l[lIndex]) {
                for(int j = i + 1; j < mIndex; j++) {
                    answer += l[lIndex] - map[j];
                    map[j] = l[lIndex];
                }

                lIndex--;
                mIndex = i;
            }
        }
    }
}
