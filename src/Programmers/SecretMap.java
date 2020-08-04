package Programmers;

import java.util.Scanner;

public class SecretMap {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        for(int i = 0; i < n; i++) {
            arr1[i] = scan.nextInt();
        }
        for(int i = 0; i < n; i++) {
            arr2[i] = scan.nextInt();
        }

        String[] a = solution(n, arr1, arr2);

        for(int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] map1 = getTwo(arr1, n);
        String[] map2 = getTwo(arr2, n);

        String[] answer = new String[n];
        for(int i = 0; i < n; i++) {
            String a = "";
            for(int j = 0; j < n; j++) {
                char one = map1[i].charAt(j);
                char two = map2[i].charAt(j);

                if(one == '0' && two == '0') {
                    a += " ";
                }
                else {
                    a += "#";
                }
            }
            answer[i] = a;
        }

        return answer;
    }

    public static String[] getTwo(int[] arr, int n) {
        String[] map = new String[n];

        for(int index = 0; index < n; index++) {
            String temp = "";
            int x = arr[index];
            while(x > 0) {
                if(x % 2 == 0) {
                    temp = "0" + temp;
                }
                else {
                    temp = "1" + temp;
                }
                x = x / 2;
            }
            while(temp.length() < n) {
                temp = "0" + temp;
            }
            System.out.println(temp);
            map[index] = temp;
        }

        return map;
    }
}
