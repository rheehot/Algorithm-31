package src.Programmers;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/43164?language=java
 */
import java.util.*;
public class TravelPath {

    static ArrayList<String> answerList = new ArrayList<>();

    public static String[] solution(String[][] tickets) {
        boolean[] visited = new boolean[tickets.length];

        for(int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals("ICN")) {
                visited[i] = true;
                travel(tickets, visited, tickets[i][1], 0, "ICN");
                visited[i] = false;
            }
        }

        String answer = "";
        if (answerList.size() == 1) {
            answer = answerList.get(0);
        }
        else {
            answer = answerList.get(0);
            for(int i = 1; i < answerList.size(); i++) {
                String tempAnswer = answerList.get(i);

                if (answer.compareTo(tempAnswer) > 0) {
                    answer = tempAnswer;
                }
            }
        }

        return answer.split(",");
    }

    public static void travel(String[][] tickets, boolean[] visited, String dep, int count, String tempAnswer) {
        count++;
        tempAnswer += ",";
        tempAnswer += dep;

        if(count == tickets.length) {
            answerList.add(tempAnswer);
            return;
        }

        for(int i = 0; i < tickets.length; i++) {
            if(!visited[i] && tickets[i][0].equals(dep)) {
                visited[i] = true;
                travel(tickets, visited, tickets[i][1], count, tempAnswer);
                visited[i] = false;
            }
        }
    }
}
