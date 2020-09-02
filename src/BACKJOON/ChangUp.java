package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class ChangUp {
    // 15:30 -> 서로 고른 문자 모르는 줄 알았음... -> 이베희로 머리 아파서 그만..
    // 재도전
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] apple = br.readLine().toCharArray();
        char[] cube = br.readLine().toCharArray();

        int aCount = (apple.length + 1) / 2;
        int cCount = cube.length / 2;

        Arrays.sort(apple);
        Arrays.sort(cube);



        bw.flush();
        bw.close();
    }
}
