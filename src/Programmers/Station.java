package Programmers;

import java.util.Scanner;

public class Station {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int len = scan.nextInt();
        int[] stations = new int[len];
        for(int i = 0; i < len; i++) {
            stations[i] = scan.nextInt();
        }
        int w = scan.nextInt();

        System.out.println(solution2(n, stations, w));
    }

    public static int solution(int n, int[] stations, int w) {
        int result = 0;
        int len = (w * 2) + 1;

        boolean[] visit = new boolean[n + 1];
        for(int i = 0; i < stations.length; i++) {
            int index = stations[i];

            for(int j = index - w; j <= index + w; j++) {
                if (j < 1) {
                    continue;
                }
                if (j > n) {
                    break;
                }

                visit[j] = true;
            }

        }

        int index = 1;
        int count = 0;
        while(true) {
            if (index > n) {
                if (count != 0) {
                    result += judge(len, count);
                }
                break;
            }
            // 전파가 닿는 곳이면
            if (visit[index]) {
                // 기지국을 세워야하는 곳이 있다면
                if (count != 0) {
                    result += judge(len, count);
                    count = 0;
                }
                index++;
                continue;
            }
            // 전파가 안 닿는 곳이면
            count++;
            index++;
        }
        return result;
    }

    public static int judge(int len, int count) {
        int result = 0;
        if (count / len == 0) {
            return 1;
        }
        else {
            result += (count/len);
        }

        if (count%len != 0) {
            result++;
        }
        return result;

    }

    public static int solution2(int n, int[] stations, int w) {
        int cover = 0;
        int result = 0;
        int len = (2 * w) + 1;

        for (int e : stations) {
            if (e - w > cover + 1) {
                result += (e - w - 1 - cover) / len;
                if ((e - w - 1 - cover) % len > 0) {
                    result ++;
                }
            }
            cover = e + w;
        }
        if (cover < n) {
            int temp = n - cover;
            if (temp / len == 0) {
                result++;
            }
            else {
                result += (temp / len);
                if (temp % len != 0) {
                    result++;
                }
            }
        }

        return result;
    }
}
