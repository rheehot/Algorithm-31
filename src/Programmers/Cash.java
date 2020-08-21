package Programmers;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Cash {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int cacheSize = scan.nextInt();

        int size = scan.nextInt();
        scan.nextLine();

        String[] cities = new String[size];
        for(int i = 0; i < size; i++) {
            cities[i] = scan.nextLine();
        }

        System.out.println(solution(cacheSize, cities));
    }

    public static int solution(int cacheSize, String[] cities) {

        if(cacheSize == 0) {
            return cities.length * 5;
        }

        int answer = 0;
        Queue<String> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();

        for(int index = 0; index < cities.length; index++) {
            String temp = cities[index].toUpperCase();

            // miss
            if(!set.contains(temp)) {
                // 캐시 꽉참
                if(q.size() >= cacheSize) {
                    String remove = q.poll();
                    set.remove(remove);
                }

                q.offer(temp);
                set.add(temp);

                answer += 5;
            }
            // hit
            else {
                int len = q.size();
                for(int i = 0; i < len; i++) {
                    String t = q.poll();

                    // not hit city
                    if(!t.equals(temp)) {
                        q.offer(t);
                    }
                }
                q.offer(temp);

                answer += 1;
            }
        }

        return answer;
    }
}
