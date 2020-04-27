package BACKJOON;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class ChikenRoad {

    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        Queue<House> chiken = new LinkedList<>();
        Stack<House> home = new Stack<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int num = scan.nextInt();
                // 집
                if(num == 1) {
                    home.push(new House(home.size(), i, j));
                }
                // 치킨집
                else if (num == 2) {
                    chiken.offer(new House(chiken.size(), i, j));
                }
            }
        }

        int[][] chikenRoaMap = new int[chiken.size()][home.size()];
        // 각 집 별로 치킨집까지 걸리는 치킨 거리를 계산
        while(!home.isEmpty()) {
            House h = home.pop();
            int size = chiken.size();
            for(int i = 0; i < size; i++) {
                House c = chiken.remove();
                chikenRoaMap[c.index][h.index] = Math.abs(c.x - h.x) + Math.abs(c.y - h.y);
                chiken.offer(c);
            }
        }

        boolean[] visit = new boolean[chiken.size()];
        for(int i = 1; i <= m; i++) {
            road(chikenRoaMap, 0, i, visit, 0);
        }

        System.out.println(result);
    }

    public static void road(int[][] roadMap, int count, int targetCount, boolean[] visit, int currentIndex) {

        if (count <= targetCount) {

        }


        if (count == targetCount) {
            int num = roadCount(roadMap, visit);
            if (num > 0 && num < result) {
                result = num;
            }
            return;
        }
        if (currentIndex >= visit.length || count > targetCount) {
            return;
        }

        visit[currentIndex] = true;
        road(roadMap, count + 1, targetCount, visit, currentIndex  +1);
        visit[currentIndex] = false;
        road(roadMap, count, targetCount, visit, currentIndex + 1);
    }

    public static int roadCount(int[][] map, boolean[] visit) {
        int num = 0;

        for(int j = 0; j < map[0].length; j++) {
            int temp = -1;
            for(int i = 0; i < visit.length; i++) {
                if(visit[i]) {
                    if(temp == -1) {
                        temp = map[i][j];
                    }
                    else if (temp > map[i][j]){
                        temp = map[i][j];
                    }
                }
            }
            num += temp;
        }

        return num;
    }
}

class House {
    int index;
    int x;
    int y;

    House(int index, int x, int y) {
        this.index = index;
        this.x = x;
        this.y = y;
    }
}
