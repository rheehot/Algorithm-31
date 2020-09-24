package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class RobotProject {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            String xStr = br.readLine();
            if(xStr == null) {
                break;
            }
            int x = Integer.parseInt(xStr) * 10000000;
            int n = Integer.parseInt(br.readLine());

            int[] legos = new int[n];
            for(int i = 0; i < n; i++) {
                legos[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(legos);

            int lIndex = 0;
            int rIndex = n - 1;

            int lLego = 0;
            int rLego = 0;
            while(lIndex < rIndex) {
                int sum = legos[lIndex] + legos[rIndex];

                if(sum == x) {
                    lLego = legos[lIndex];
                    rLego = legos[rIndex];
                    break;
                }
                else if(sum < x) {
                    lIndex++;
                }
                else {
                    rIndex--;
                }
            }

            if(lLego != 0 && rLego != 0) {
                bw.write("yes " + lLego + " " + rLego + "\n");
            }
            else {
                bw.write("danger");
            }
        }

        bw.flush();
        bw.close();
    }
}
