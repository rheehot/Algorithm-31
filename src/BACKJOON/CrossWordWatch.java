package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class CrossWordWatch {
    static int R, C;
    static char[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for(int i = 0; i < R; i++) {
            String temp = br.readLine();
            for(int j = 0; j < C; j++) {
                map[i][j] = temp.charAt(j);
            }
        }

        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < R; i++) {
            int index = 0;
            String temp = "";

            while(index < C) {
                // 막힘
                if(map[i][index] == '#') {
                    // 리스트에 추가
                    if(!temp.equals("")) {
                        if(temp.length() > 1) {
                            list.add(temp);
                        }
                        temp = "";
                    }
                    index++;
                    continue;
                }
                temp += map[i][index];
                index++;
            }
            if(!temp.equals("")) {
                if(temp.length() > 1) {
                    list.add(temp);
                }
            }
        }

        for(int j = 0; j < C; j++) {
            int index = 0;
            String temp = "";

            while(index < R) {
                if(map[index][j] == '#') {
                    if(!temp.equals("")) {
                        if(temp.length() > 1) {
                            list.add(temp);
                        }
                        temp = "";
                    }
                    index++;
                    continue;
                }
                temp += map[index][j];
                index++;
            }
            if(!temp.equals("")) {
                if(temp.length() > 1) {
                    list.add(temp);
                }
            }
        }

        Collections.sort(list);
        bw.write(list.get(0));

        bw.flush();
        bw.close();
    }
}
