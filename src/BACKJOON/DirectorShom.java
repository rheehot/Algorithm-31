package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DirectorShom {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int num = 0;

        while(N > 0) {
            num++;
            String str = Integer.toString(num);

            if(str.contains("666"))
                N--;
        }

        bw.write(num+"");

        bw.flush();
        bw.close();
    }
}
