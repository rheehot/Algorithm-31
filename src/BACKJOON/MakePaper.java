package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class MakePaper {
    public static int[][] paper;
    public static int whiteCount;
    public static int blueCount;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 0: 하얀색, 1: 파란색
        judge(0, 0, N);

        bw.write(whiteCount + "\n" + blueCount);
        bw.flush();
        bw.close();
    }

    public static void judge(int startI, int startJ, int count) {
        if(count == 1) {
            if(paper[startI][startJ] == 0) {
                whiteCount++;
            }
            else {
                blueCount++;
            }
            return;
        }

        int temp = paper[startI][startJ];
        boolean flag = false;
        for(int i = 0; i < count; i++) {
            for(int j = 0; j < count; j++) {
                if(temp != paper[startI + i][startJ + j]) {
                    flag = true;
                    break;
                }
            }
            if(flag) {
                break;
            }
        }

        if(!flag) {
            if(temp == 0) {
                whiteCount++;
            }
            else {
                blueCount++;
            }
            return;
        }

        judge(startI, startJ, count / 2);
        judge(startI + count / 2, startJ, count / 2);
        judge(startI + count / 2, startJ + count / 2, count / 2);
        judge(startI, startJ + count / 2, count / 2);
    }
}
