package BACKJOON;

import java.util.Scanner;

public class CircleSushi {
    public static int[] sushi;
    public static int[] visit;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // 벨트 위 접시
        int N = scan.nextInt();
        // 초밥 가짓수
        int d = scan.nextInt();
        // 연속 접시 수
        int k = scan.nextInt();
        // 쿠폰 번호
        int c = scan.nextInt();

        sushi = new int[N];
        visit = new int[d + 1];

        for(int i = 0; i < N; i++) {
            sushi[i] = scan.nextInt();
        }

        int total = 0, max = 0;
        for(int i = 0; i < k; i++) {
            if(visit[sushi[i]] == 0) {
                total++;
            }
            visit[sushi[i]]++;
        }
        max = total;

        for(int i = 1; i < N; i++) {
            if(max <= total) {
                if(visit[c] == 0) {
                    max = total + 1;
                }
                else {
                    max = total;
                }
            }
            visit[sushi[i - 1]]--;
            if(visit[sushi[i - 1]] == 0) {
                total--;
            }

            if(visit[sushi[(i + k -1) % N]] == 0) {
                total++;
            }
            visit[sushi[(i + k - 1) % N]]++;
        }

        System.out.println(max);
    }
}
