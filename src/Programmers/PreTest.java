package Programmers;

import java.util.*;

class PreTest {
    public int[] solution(int[] answers) {
        
        int oneResult = one(answers);
        int twoResult = two(answers);
        int threeResult = three(answers);
        
        int max = Math.max(oneResult, Math.max(twoResult, threeResult));
        ArrayList<Integer> temp = new ArrayList<>();
        if(max == oneResult) {
            temp.add(1);
        }
        if(max == twoResult) {
            temp.add(2);
        }
        if(max == threeResult) {
            temp.add(3);
        }

        int[] answer = new int[temp.size()];
        int size = 0;
        for(int t : temp) {
            answer[size++] = t;
        }
        
        return answer;
    }
    
    public static int one(int[] answers) {
        int result = 0;
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == (i % 5) + 1) {
                result++;
            }
        }
        return result;
    }
    public static int two(int[] answers) {
        int[] twoAnswers = {2, 1, 2, 3, 2, 4, 2, 5};
        int result = 0;
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == twoAnswers[i % twoAnswers.length]) {
                result++;
            }
        }
        return result;
    }
    public static int three(int[] answers) {
        int[] threeAnswers = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int result = 0;
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == threeAnswers[i % threeAnswers.length]) {
                result++;
            }
        }
        return result;
    }
}
