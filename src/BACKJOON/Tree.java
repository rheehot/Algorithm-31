package BACKJOON;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class TreeYear {
    ArrayList<Integer> years;

    TreeYear(ArrayList<Integer> years) {
        this.years = years;
    }
}

public class Tree {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int M = scan.nextInt();
        int K = scan.nextInt();

        // 로봇이 주는 양분 지도
        int[][] A = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                A[i][j] = scan.nextInt();
            }
        }

        // 현재 나무 지도
        TreeYear[][] treeMap = new TreeYear[N + 1][N + 1];
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                ArrayList<Integer> temp = new ArrayList<>();
                treeMap[i][j] = new TreeYear(temp);
            }
        }
        for(int m = 0; m < M; m++) {
            int i = scan.nextInt();
            int j = scan.nextInt();
            int y = scan.nextInt();

            treeMap[i][j].years.add(y);
        }

        // 현재 양분 지도
        int[][] foodMap = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                foodMap[i][j] = 5;
            }
        }

        for(int k = 1; k <= K; k++) {
            // 봄
            // 죽은 나무 지도 (여름에 추가될 양분만 가지고 있으면 되므로 int 배열)
            int[][] deadTree = new int[N + 1][N + 1];

            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    // 심어진 나무가 있다면
                    if (treeMap[i][j].years.size() > 0) {
                        ArrayList<Integer> origin = treeMap[i][j].years;
                        // 나무의 나이순으로 정렬
                        Collections.sort(origin);

                        ArrayList<Integer> newTrees = new ArrayList<>();
                        for(int t = 0; t < origin.size(); t++) {
                            // 나이만큼 양분 먹고 나이+1
                            if (foodMap[i][j] >= origin.get(t)) {
                                foodMap[i][j] -= origin.get(t);
                                newTrees.add(origin.get(t) + 1);
                            }
                            // 양분이 부족해서 나무 죽음
                            else {
                                deadTree[i][j] += (origin.get(t) / 2);
                            }
                        }

                        treeMap[i][j].years = newTrees;
                    }
                }
            }

            // 여름
            foodMap = summer(foodMap, deadTree);

            // 가을
            treeMap = fall(treeMap);

            // 겨울
            foodMap = winter(foodMap, A);
        }

        int result = 0;
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                result += treeMap[i][j].years.size();
            }
        }

        System.out.println(result);
    }

    public static int[][] summer(int[][] foodMap, int[][] deadTree) {
        for(int i = 1; i < foodMap.length; i++) {
            for(int j = 1; j < foodMap.length; j++) {
                foodMap[i][j] += deadTree[i][j];
            }
        }

        return foodMap;
    }

    public static TreeYear[][] fall(TreeYear[][] treeMap) {

        // 인접한 8방향
        int[] dirI = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dirJ = {-1, 0, 1, -1, 1, -1, 0, 1};

        TreeYear[][] temp = new TreeYear[treeMap.length][treeMap.length];
        for(int i = 1; i < treeMap.length; i++) {
            for(int j = 1; j < treeMap.length; j++) {
                temp[i][j] = treeMap[i][j];
            }
        }

        for(int i = 1; i < temp.length; i++) {
            for(int j = 1; j < temp.length; j++) {
                // 심어진 나무가 있다면
                if(temp[i][j].years.size() > 0) {
                    ArrayList<Integer> origin = temp[i][j].years;
                    int count = 0;
                    for(int t = 0; t < origin.size(); t++) {
                        // 나무의 나이가 5의 배수면 나무 번식
                        if (origin.get(t) % 5 == 0) {
                            count++;
                        }
                    }
                    if (count == 0) {
                        continue;
                    }

                    for(int d = 0; d < dirI.length; d++) {
                        if (i + dirI[d] < 1 || i + dirI[d] >= treeMap.length) {
                            continue;
                        }
                        if (j + dirJ[d] < 1 || j + dirJ[d] >= treeMap.length) {
                            continue;
                        }

                        for(int c = 0; c < count; c++) {
                            treeMap[i + dirI[d]][j + dirJ[d]].years.add(1);
                        }
                    }
                }
            }
        }

        return treeMap;
    }

    public static int[][] winter(int[][] foodMap, int[][] A) {

        for(int i = 1; i < foodMap.length; i++) {
            for(int j = 1; j < foodMap.length; j++) {
                foodMap[i][j] += A[i][j];
            }
        }

        return foodMap;
    }
}
