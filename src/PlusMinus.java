/*
 * https://www.hackerrank.com/challenges/plus-minus/problem
 */
import java.util.*;
public class PlusMinus {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        double positive = 0;
        double negative = 0;
        double zero = 0;
        for(int i = 0 ; i < num; i++) {
            int temp = scan.nextInt();
            if (temp == 0) {
                zero++;
            }
            else if (temp < 0) {
                negative++;
            }
            else {
                positive++;
            }
        }

        double l = Double.valueOf(num);
        double p = positive / l;
        System.out.println(String.format("%.6f", p));
        double n = negative / l;
        System.out.println(String.format("%.6f", n));
        double z = zero / l;
        System.out.println(String.format("%.6f", z));
    }
}