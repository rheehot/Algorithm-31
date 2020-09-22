package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Wheel {
    static int[][] wheel = new int[5][8];
    static int[] indexArr = new int[5];
    static int[] dirArr = new int[5];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 1; i <= 4; i++) {
            String str = br.readLine();
            for(int j = 0; j < 8; j++) {
                wheel[i][j] = str.charAt(j) - '0';
            }
        }

        int K = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int wNum = Integer.parseInt(st.nextToken());
            int wDir = Integer.parseInt(st.nextToken());

            choiceDir(wNum, wDir);
        }

        int answer = check();
        bw.write(answer + "");

        bw.flush();
        bw.close();
    }

    public static void choiceDir(int wNum, int wDir) {
        dirArr[wNum] = wDir;

        int index = wNum;
        while(index > 1) {
            int curIndex = indexArr[index] - 2;
            if(curIndex < 0) {
                curIndex += 8;
            }
            int frontIndex = indexArr[index - 1] + 2;
            if(frontIndex > 7) {
                frontIndex -= 8;
            }

            if(wheel[index][curIndex] == wheel[index - 1][frontIndex]) {
                break;
            }

            if(dirArr[index] == 1) {
                dirArr[index - 1] = -1;
            }
            else {
                dirArr[index - 1] = 1;
            }

            index--;
        }

        index = wNum;
        while(index < 4) {
            int curIndex = indexArr[index] + 2;
            if(curIndex > 7) {
                curIndex -= 8;
            }
            int backIndex = indexArr[index + 1] - 2;
            if(backIndex < 0) {
                backIndex += 8;
            }

            if(wheel[index][curIndex] == wheel[index + 1][backIndex]) {
                break;
            }

            if(dirArr[index] == 1) {
                dirArr[index + 1] = -1;
            }
            else {
                dirArr[index + 1] = 1;
            }

            index++;
        }

        move();
    }


    public static void move() {
        for(int i = 1; i <= 4; i++) {
            if(dirArr[i] == 1) {
                indexArr[i]--;
                if(indexArr[i] < 0) {
                    indexArr[i] += 8;
                }
            }

            if(dirArr[i] == -1) {
                indexArr[i]++;
                if(indexArr[i] > 7) {
                    indexArr[i] -=8;
                }
            }
        }

        Arrays.fill(dirArr, 0);
    }

    public static int check() {
        int count = 0;
        for(int i = 1; i <= 4; i++) {
            if(wheel[i][indexArr[i]] != 0) {
                count += Math.pow(2, i - 1);
            }
        }
        return count;
    }

}
