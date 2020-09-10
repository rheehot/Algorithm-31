package Programmers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

// 17:00
public class Kakao2019Key {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        String[][] map = new String[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                map[i][j] = br.readLine();
            }
        }

        bw.write(solution(map) +"");
        bw.flush();
        bw.close();
    }

    // 후보키 모음
    static ArrayList<HashSet<Integer>> cadidates;

    public static int solution(String[][] relation) {
        cadidates = new ArrayList<>();
        select(0, new HashSet<Integer>(), relation);
        return cadidates.size();
    }

    static void select(int index, HashSet<Integer> selects, String[][] relation) {
        if(index == relation[0].length) {
            for(int i = 0; i < cadidates.size(); i++) {
                if(selects.containsAll(cadidates.get(i))) {
                    return;
                }
            }

            HashSet<String> set = new HashSet<>();
            for(int i = 0; i < relation.length; i++) {
                String temp = "";
                for(int col : selects) {
                    temp += relation[i][col] + ",";
                }
                if(set.contains(temp)) {
                    return;
                }
                set.add(temp);
            }

            cadidates.add(selects);
            return;
        }

        HashSet<Integer> copy = new HashSet<>();
        HashSet<Integer> copy2 = new HashSet<>();

        for(Integer val : selects) {
            copy.add(val);
            copy2.add(val);
        }

        select(index + 1, copy2, relation);
        copy.add(index);
        select(index + 1, copy, relation);

    }
}
