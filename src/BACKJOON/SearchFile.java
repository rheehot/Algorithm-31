package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SearchFile {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        String target = br.readLine();

        String[] temp = str.split(target);
        int len = 0;
        for(int i = 0; i < temp.length; i++) {
            len += temp[i].length();
        }

        int count = str.length() - len;
        count /= target.length();

        bw.write(count + "");
        bw.flush();
        bw.close();
    }
}
