package Test;

import java.util.HashMap;
import java.util.Scanner;

public class SummerThree {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int total_sp = scan.nextInt();
        int len = scan.nextInt();
        int[][] skills = new int[len][2];
        for(int i = 0; i < len; i++) {
            skills[i][0] = scan.nextInt();
            skills[i][1] = scan.nextInt();
        }

        int[] result = solution(total_sp, skills);
        for(int i = 1; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    static int[] childsNum;
    static int[] result;
    public static int[] solution(int total_sp, int[][] skills) {

        childsNum = new int[skills.length + 2];
        result = new int[skills.length + 2];

        //<자식, 부모>
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < skills.length; i++) {
            map.put(skills[i][1], skills[i][0]);
        }

        for(int i = 0; i < skills.length; i++) {
            childsNum[skills[i][0]]++;
        }
        for(int i = 1; i < childsNum.length; i++) {
            if(childsNum[i] == 0) {
                visit(map, i);
            }
        }

        int num = 0;
        for(int i = 0; i< result.length; i++) {
            num += result[i];
        }
        num = total_sp/num;

        int[] answer = new int[skills.length + 1];
        for(int i = 1; i < result.length; i++) {
            answer[i - 1] = result[i] *= num;
        }
        return answer;
    }

    public static void visit(HashMap<Integer, Integer> map, int target) {
        result[target] = 1;

        int start = target;
        while(true) {
            if(map.containsKey(target)) {
                target = map.get(target);
                result[target]++;
            }
            else {
                break;
            }
        }
    }
}