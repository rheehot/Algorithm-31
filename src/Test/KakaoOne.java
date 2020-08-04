package Test;

import java.util.HashMap;
import java.util.Scanner;

class Point {
    int i;
    int j;

    Point(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

public class KakaoOne {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scan.nextInt();
        }
        String hand = scan.nextLine();

        System.out.println(solution(numbers, hand));
    }

    public static String solution(int[] numbers, String hand) {
        String answer = "";

        Point curLeft = new Point(3, 0);
        Point curRight = new Point(3, 2);

        HashMap<Integer, Point> map = new HashMap<>();
        map.put(0, new Point(3, 1));
        map.put(2, new Point(0, 1));
        map.put(5, new Point(1, 1));
        map.put(8, new Point(2, 1));

        for (int num : numbers) {
            // 왼손만 가능
            if (num == 1 || num == 4 || num == 7) {
                answer += "L";
                curLeft = new Point(num / 3, 0);
                continue;
            }
            // 오른손만 가능
            if (num == 3 || num == 6 || num == 9) {
                answer += "R";
                curRight = new Point(num / 3 - 1, 2);
                continue;
            }
            // 왼손, 오른손 모두 가능
            Point target = map.get(num);
            int distanceLeft = Math.abs(target.i - curLeft.i) + Math.abs(target.j - curLeft.j);
            int distanceRight = Math.abs(target.i - curRight.i) + Math.abs(target.j - curRight.j);

            if (distanceLeft == distanceRight) {
                if (hand.equals("right")) {
                    answer += "R";
                    curRight = target;
                } else {
                    answer += "L";
                    curLeft = target;
                }
            } else if (distanceLeft < distanceRight) {
                answer += "L";
                curLeft = target;
            } else if (distanceLeft > distanceRight) {
                answer += "R";
                curRight = target;

            }
        }

        return answer;
    }
}

