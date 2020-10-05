package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ2098 {
    static int n;
    static ArrayList<TravelNode>[] list;
    static int[] dist;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }



        bw.flush();
        bw.close();
    }
}
class TravelNode {
    int end;
    int weight;

    TravelNode(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
}
