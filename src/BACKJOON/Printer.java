package BACKJOON;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Printer {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int T = scan.nextInt();
        for(int i = 0; i < T; i++) {
            int n = scan.nextInt();
            int target = scan.nextInt();
            int[] p = new int[11];
            Queue<PrinterNode> q = new LinkedList<>();

            for(int j = 0; j < n; j++) {
                int pri = scan.nextInt();

                p[pri]++;
                q.offer(new PrinterNode(j, pri));
            }

            int count = 0;
            while(!q.isEmpty()) {
                PrinterNode temp = q.poll();

                boolean hasBig = false;
                for(int j = temp.priority + 1; j < 11; j++) {
                    if(p[j] > 0) {
                        hasBig = true;
                        q.offer(temp);
                        break;
                    }
                }
                if(!hasBig) {
                    if(temp.index == target) {
                        break;
                    }
                    p[temp.priority]--;
                    count++;
                }
            }
            System.out.println(count + 1);
        }
    }
}
class PrinterNode {
    int index;
    int priority;

    PrinterNode(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }
}
