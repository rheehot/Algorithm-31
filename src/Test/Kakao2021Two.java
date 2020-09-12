package Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Kakao2021Two {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int orderN = Integer.parseInt(br.readLine());
        int courseN = Integer.parseInt(br.readLine());

        String[] orders = new String[orderN];
        for(int i = 0; i < orderN; i++) {
            orders[i] = br.readLine();
        }

        int[] course = new int[courseN];
        for(int i = 0; i < courseN; i++) {
            course[i] = Integer.parseInt(br.readLine());
        }

        String[] answer = solution(orders, course);
        for(int i = 0; i < answer.length; i++) {
            bw.write(answer[i] + "\n");
        }

        bw.flush();
        bw.close();
    }

    static HashMap<String, Integer> map = new HashMap<>();
    public static String[] solution(String[] orders, int[] course) {
        for(int i = 0; i < orders.length; i++) {
            char[] temp = orders[i].toCharArray();
            Arrays.sort(temp);

            for(int j = 0; j < course.length; j++) {
                choice(temp, course[j], 0, "");
            }
        }

        String[] keys = map.keySet().toArray(new String[map.keySet().size()]);
        Arrays.sort(keys, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        List<String> aList = new ArrayList<>();
        int index = 0;
        for(int i = 0; i < course.length; i++) {
            int count = course[i];

            int startIndex = index;
            int maxCount = 0;
            while(index < keys.length && keys[index].length() == count) {

                if (map.get(keys[index]) > maxCount) {
                    maxCount = map.get(keys[index]);
                }

                index++;
            }
            if(maxCount < 2) {
                continue;
            }

            for(int j = startIndex; j < index; j++) {
                if(map.get(keys[j]) == maxCount) {
                    aList.add(keys[j]);
                }
            }
        }

        Collections.sort(aList);
        String[] answer = aList.toArray(new String[aList.size()]);

        return answer;
    }

    public static void choice(char[] arr, int target, int index, String r) {
        if(r.length() == target) {
            if (map.containsKey(r)) {
                map.put(r, map.get(r) + 1);
            }
            else {
                map.put(r, 1);
            }
            return;
        }
        if(index >= arr.length) {
            return;
        }

        choice(arr, target, index + 1, r + arr[index]);
        choice(arr, target, index + 1, r);
    }

}
