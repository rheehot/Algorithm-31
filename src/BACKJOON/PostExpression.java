package BACKJOON;

import java.util.Scanner;
import java.util.Stack;

public class PostExpression {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        char[] s = scan.next().toCharArray();
        int len = s.length;
        double[] array = new double[n];
        Stack<Double> stack = new Stack<>();

        for(int i = 0; i < n; i++) {
            array[i] = scan.nextInt();
        }

        for(int i = 0; i < len; i++) {
            char ch = s[i];

            switch(ch) {
                case '+':
                case '-':
                case '*':
                case '/':
                    cal(stack, stack.pop(), stack.pop(), ch);
                    break;
                default:
                    stack.push(array[ch - 'A']);
            }
        }
        System.out.format("%.2f", stack.peek());
    }

    public static void cal(Stack<Double> stack, double a, double b, char op) {
        switch(op) {
            case '+':
                stack.push(b + a);
                break;
            case '-':
                stack.push(b - a);
                break;
            case '*':
                stack.push(b * a);
                break;
            case '/':
                stack.push(b / a);
                break;

        }
    }
}
