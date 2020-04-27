package Test;

import java.util.Scanner;

// 1번
public class TestThree {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        String[] pur = new String[n];
        for(int i = 0; i < n; i++) {
            pur[i] = scan.next();
        }

        int[] result = solution(pur);
        for(int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    static public int[] solution(String[] purchase) {
        int[] prices = new int[366];
        int[] grades = new int[366];

        for(int i = 0; i < purchase.length; i++) {
            String[] temp = purchase[i].split(" ");

            // 구매 날짜
            String[] date = temp[0].split("/");
            int day = 0;
            for(int j = 1; j < Integer.parseInt(date[1]); j++) {
                day += month[j];
            }
            day += Integer.parseInt(date[2]);

            // 구매 금액
            int price = Integer.parseInt(temp[temp.length - 1]);
            for(int j = day; j < day + 30; j++) {
                if (j > 365) {
                    break;
                }

                prices[j] += price;
            }
        }

        int[] result = new int[5];
        for(int i = 1; i < prices.length; i++) {
            int g = judgeGrade(prices[i]);

            result[g]++;
        }

        return result;
    }

    static public int judgeGrade(int price) {
        if (price < 10000 ) {
            return 0;
        }
        else if (price < 20000) {
            return 1;
        }
        else if (price < 50000) {
            return 2;
        }
        else if (price < 100000) {
            return 3;
        }
        else {
            return 4;
        }
    }

    static int[] month = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
}
