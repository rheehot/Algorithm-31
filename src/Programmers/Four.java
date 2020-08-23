package Programmers;

import java.util.Scanner;

public class Four {
    public void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        scan.nextLine();
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextLine();
        }
    }
}