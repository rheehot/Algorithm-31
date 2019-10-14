package src.Programmers;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/12981?language=java
 */

import java.util.*;
public class WordChainGame {
    static int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        HashMap<String, Integer> wordsMap = new HashMap();
        int[] people = new int[n + 1];

        int index = 1;
        wordsMap.put(words[0], 1);

        for(int i = 0; i < words.length; i++) {

            answer[0] = index;
            people[index]++;
            answer[1] = people[index];

            // 한글자
            if (words[i].length() <= 1) {
                return answer;
            }
            // 첫 사람이 아닐 경우
            if (i != 0) {
                // 동일 단어
                if(wordsMap.containsKey(words[i])) {
                    return answer;
                }
                // 첫단어와 끝 단어
                String prevWord = words[i - 1].toLowerCase();
                String curWord = words[i].toLowerCase();
                char last = prevWord.charAt(prevWord.length() - 1);
                char first = curWord.charAt(0);

                if (last != first) {
                    return answer;
                }

            }
            wordsMap.put(words[i], 1);
            index++;
            if(index > n) {
                index = 1;
            }
        }

        answer[0] = 0;
        answer[1] = 0;

        return answer;
    }
}
