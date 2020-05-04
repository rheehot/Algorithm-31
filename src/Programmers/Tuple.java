package Programmers;

import java.util.*;

public class Tuple {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();

        int[] result = solution(s);
        for(int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static int[] solution(String s) {
        s = s.replace('{', '/');
        s = s.replace('}','/');
        String[] temp = s.split("/");

        ArrayList<String> ss = new ArrayList<>();
        for(int i = 0; i < temp.length; i++) {
            if (temp[i].equals(",") || temp[i].isBlank()) {
                continue;
            }
            ss.add(temp[i]);
        }

        // ArrayList 요소를 길이순으로 정렬
        Collections.sort(ss, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1.length() - o2.length());
            }
        });

        int[] result = new int[ss.size()];
        HashSet<Integer> rMap = new LinkedHashSet<>();
        result[0] = Integer.parseInt(ss.get(0));
        rMap.add(result[0]);
        int index = 1;
        // 길이가 하나면 무조건 하나임
        if (ss.size() == 1) {
            return result;
        }

        for(int i = 1; i < ss.size(); i++) {
            String[] t = ss.get(i).split(",");
            for(int j = 0; j < t.length; j++) {
                if (t[j].isBlank()) {
                    continue;
                }
                if(rMap.contains(Integer.parseInt(t[j]))) {
                    continue;
                }
                result[index] = Integer.parseInt(t[j]);
                rMap.add(Integer.parseInt(t[j]));
                index++;
            }
        }

        return result;
    }
}
