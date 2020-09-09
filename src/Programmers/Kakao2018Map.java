package Programmers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Kakao2018Map {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for(int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(br.readLine());
        }
        for(int i = 0; i < n; i++) {
            arr2[i] = Integer.parseInt(br.readLine());
        }

        String[] answer = solution(n, arr1, arr2);

        for(int i = 0; i < n; i++) {
            bw.write(answer[i]+"\n");
        }

        bw.flush();
        bw.close();
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] one = mapToTwo(arr1, n);
        String[] two = mapToTwo(arr2, n);

        String[] answer = new String[n];
        for(int i = 0; i < n; i++) {
            String tempOne = one[i];
            String tempTwo = two[i];

            String tempAnswer = "";
            for(int j = 0; j < n; j++) {
                if(tempOne.charAt(j) == '1' || tempTwo.charAt(j) == '1') {
                    tempAnswer += "#";
                }
                else {
                    tempAnswer += " ";
                }
            }
            answer[i] = tempAnswer;
        }

        return answer;
    }

    public static String[] mapToTwo(int[] arr1, int n) {
        String[] map = new String[n];

        for(int i = 0; i < n; i++) {
            String temp = "";

            int t = arr1[i];
            while(t > 0) {
                temp = (t % 2) + temp;
                t /= 2;
            }

            if(temp.length() < n) {
                while(temp.length() < n) {
                    temp = "0" + temp;
                }
            }

            map[i] = temp;
        }

        return map;
    }
}
