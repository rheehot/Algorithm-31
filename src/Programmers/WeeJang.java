package Programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WeeJang {
    public static void main(String[] args) throws Exception {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(clothes));
    }

    public static int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        for(int i = 0; i < clothes.length; i++) {
            if(map.containsKey(clothes[i][1])) {
                map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
            }
            else {
                map.put(clothes[i][1], 1);
                list.add(clothes[i][1]);
            }
        }

        int result = 1;
        for(int s = 0; s < list.size(); s++) {
            String temp = list.get(s);
            result *= (map.get(temp) + 1);
        }

        return result - 1;
    }
}
