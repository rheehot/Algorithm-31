package Test;

import java.util.HashMap;
import java.util.Map;

// 2번
public class TestTwo {
    class Student {
        String ip;
        String lan;
        int score;

        Student(String ip, String lan, int score) {
            this.ip = ip;
            this.lan = lan;
            this.score = score;
        }
    }

    public int solution(String[] ip_addrs, String[] langs, int[] scores) {

        Student[] s = new Student[ip_addrs.length];
        Map<String, Integer> m = new HashMap<>();

        // 학생들과 각 ip별로 학생 수를 저장
        for(int i = 0; i < ip_addrs.length; i++) {
            if(langs[i].equals("C++") || langs[i].equals("C#")) {
                s[i] = new Student(ip_addrs[i], "C", scores[i]);
            }
            else {
                s[i] = new Student(ip_addrs[i], langs[i], scores[i]);
            }
            if (m.containsKey(ip_addrs[i])) {
                int temp = m.get(ip_addrs[i]);
                temp++;
                m.put(ip_addrs[i], temp);
            }
            else {
                m.put(ip_addrs[i], 1);
            }
        }

        int result = s.length;
        // ip
        for(String key: m.keySet()) {
            if(m.get(key) >= 2) {
                Student[] temp = new Student[m.get(key)];

                int j = 0;
                for(int i = 0; i < s.length; i++) {
                    if (s[i].ip.equals(key)) {
                        temp[j] = s[i];
                        j++;
                    }
                }

                result += judge(temp);
            }
        }

        return result;
    }

    public int judge(Student[] s) {
        switch (s.length) {
            case 2:
                if(s[0].lan.equals(s[1].lan) && s[0].score == s[1].score) {
                    return -2;
                }
                else {
                    return 0;
                }
            case 3:
                // 3명 조건
                if(s[0].lan.equals(s[1].lan) && s[1].lan.equals(s[2].lan)) {
                    return -3;
                }
                else {
                    return 0;
                }
            default:
                return (-1 * s.length);
        }
    }
}
