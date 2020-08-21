package Programmers;

import java.util.*;

public class NewsClustering {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String str1 = scan.nextLine();
        String str2 = scan.nextLine();

        System.out.println(solution(str1, str2));
    }

    public static int solution(String str1, String str2) {

        if (str1.length() == 0 && str2.length() == 0) {
            return 65536;
        }
        if(str1.length() == 0 || str2.length() == 0) {
            return 0;
        }

        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        HashMap<String, Integer> strOneMap = new HashMap<>();
        HashMap<String, Integer> strTwoMap = new HashMap<>();

        for(int i = 0; i < str1.length() - 1; i++) {

            if (!(str1.charAt(i) >= 'A' && str1.charAt(i) <= 'Z')) {
                continue;
            }
            if (!(str1.charAt(i + 1) >= 'A' && str1.charAt(i + 1) <= 'Z')) {
                continue;
            }

            String temp = str1.substring(i, i + 2);

            if (strOneMap.containsKey(temp)) {
                strOneMap.replace(temp, strOneMap.get(temp) + 1);
            }
            else {
                strOneMap.put(temp, 1);
            }
        }

        for(int i = 0; i < str2.length() - 1; i++) {

            if (!(str2.charAt(i) >= 'A' && str2.charAt(i) <= 'Z')) {
                continue;
            }
            if (!(str2.charAt(i + 1) >= 'A' && str2.charAt(i + 1) <= 'Z')) {
                continue;
            }

            String temp = str2.substring(i, i + 2);

            if (strTwoMap.containsKey(temp)) {
                strTwoMap.replace(temp, strTwoMap.get(temp) + 1);
            } else {
                strTwoMap.put(temp, 1);
            }
        }

        if (strOneMap.size() == 0 && strTwoMap.size() == 0) {
            return 65536;
        }
        if(strOneMap.size() == 0 || strTwoMap.size() == 0) {
            return 0;
        }

        String[] strOneArr = strOneMap.keySet().toArray(new String[strOneMap.size()]);
        String[] strTwoArr = strTwoMap.keySet().toArray(new String[strTwoMap.size()]);

        double sum = 0;
        double gyo = 0;
        for(int i = 0; i < strOneArr.length; i++) {
            if(strTwoMap.containsKey(strOneArr[i])) {
                int one = strOneMap.get(strOneArr[i]);
                int two = strTwoMap.get(strOneArr[i]);
                sum += Math.max(one, two);
                gyo += Math.min(one, two);
            }
            else {
                sum += strOneMap.get(strOneArr[i]);
            }
        }
        for(int i = 0; i < strTwoArr.length; i++) {
            if(!strOneMap.containsKey(strTwoArr[i])) {
                sum += strTwoMap.get(strTwoArr[i]);
            }
        }

        double answer = gyo / sum;

        return (int) (answer * 65536);
    }
}
