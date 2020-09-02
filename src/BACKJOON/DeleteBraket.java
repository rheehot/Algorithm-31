package BACKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 14:30 - 15:25
public class DeleteBraket {
    public static String str;
    public static int[] strArr;

    public static ArrayList<String> arr = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        int startCount = 0;
        strArr = new int[str.length()];
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') {
                startCount++;
                s.push(startCount);
                strArr[i] = startCount;
            }
            if(str.charAt(i) == ')') {
                strArr[i] = s.pop();
            }
        }

        boolean[] visit = new boolean[startCount + 1];
        solution(visit, 0);

        Collections.sort(arr);
        for(int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }

    public static void solution(boolean[] visit, int index) {

        if(index == visit.length - 1) {
            String a = "";
            for(int i = 0; i < str.length(); i++) {
                char temp = str.charAt(i);
                if(temp == '(' || temp == ')') {
                    if(!visit[strArr[i]]) {
                        a += temp;
                    }
                    continue;
                }
                a += temp;
            }

            if(!a.equals(str) && !arr.contains(a)) {
//                System.out.println(a);
                arr.add(a);
            }

            return;
        }

        visit[index + 1] = true;
        solution(visit, index + 1);
        visit[index + 1] = false;
        solution(visit, index + 1);
    }
}