package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ15961 {
    static int n, d, k, c;
    // 초밥 종류에 따른 갯수를 담은 배열
    static int[] sushiNums;
    // 컨테이너 벨트
    static int[] belt;
    // 초밥 종류 갯수
    static int sushi;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        belt = new int[n];
        sushiNums = new int[d + 1];

        // 컨테이너 벨트 설정
        for(int index = 0; index < n; index++) {
            belt[index] = Integer.parseInt(br.readLine());
        }

        int max = 0;
        setWindow();
        if(sushiNums[c] == 0) {
            max = Math.max(max, sushi + 1);
        }
        else {
            max = Math.max(max, sushi);
        }

        for(int index = 0; index < n - 1; index++) {
            int firstSushi = belt[index];
            int addSushi = belt[(index + k) % n];

            sushiNums[firstSushi]--;
            if(sushiNums[firstSushi] == 0) {
                sushi--;
            }

            if(sushiNums[addSushi] == 0) {
                sushi++;
            }
            sushiNums[addSushi]++;

            if(sushiNums[c] == 0) {
                max = Math.max(max, sushi + 1);
            }
            else {
                max = Math.max(max, sushi);
            }
        }

        bw.write(max + "");
        bw.flush();
        bw.close();
    }

    public static void setWindow() {
        for(int index = 0; index < k; index++) {
            if(sushiNums[belt[index]] == 0) {
                sushi++;
            }

            sushiNums[belt[index]]++;
        }
    }
}
