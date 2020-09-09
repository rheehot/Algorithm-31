package Programmers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Kakao2018Cache {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cacheSize = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        String[] cities = new String[n];
        for(int i = 0; i < n; i++) {
            cities[i] = br.readLine();
        }

        bw.write(solution(cacheSize, cities) + "");

        bw.flush();
        bw.close();
    }

    public static int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0) {
            return cities.length * 5;
        }

        List<String> list = new ArrayList<>();

        int time = 0;
        for(int i = 0; i < cities.length; i++) {

            String city = cities[i].toLowerCase();
            if(list.size() < cacheSize) {
                list.add(city);
                time += 5;
                continue;
            }

            // 캐시에 있음
            if(list.contains(city)) {
                time += 1;

                list.remove(city);
                list.add(city);
            }
            // 캐시에 없음
            else {
                list.remove(0);
                list.add(city);
                time += 5;
            }
        }

        return time;
    }
}
