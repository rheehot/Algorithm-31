package Test;

import java.util.*;

public class KakaoTwo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String expression = scan.nextLine();

        System.out.print(solution(expression));

    }

    public static long answer = 0;
    public static long solution(String expression) {
        Queue<String> exQueue = new LinkedList<>();
        String tempNumber = "";

        ArrayList<String> yun = new ArrayList<>();
        for(int i = 0; i < expression.length(); i++) {
            char temp = expression.charAt(i);

            // 수식일 경우
            if(temp == '-' || temp == '+' || temp == '*') {
                // 앞의 숫자를 수식에 넣기

                exQueue.add(tempNumber);
                tempNumber = "";
                exQueue.add(temp+"");
                if (!yun.contains(temp+"")) {
                    yun.add(temp+"");
                }
            }
            else {
                // 숫자일 경우
                tempNumber += temp;
            }
        }
        exQueue.add(tempNumber);

        boolean[] visit = new boolean[yun.size()];
        judge(exQueue, yun, visit, 0);

        return answer;
    }
    public static void judge(Queue<String> exQueue, ArrayList<String> yun, boolean[] visit, int count) {

        // 연산자를 모두 계산한 경우
        if (count >= visit.length) {
            if (exQueue.isEmpty()) {
                return;
            }
            long amount = Long.parseLong(exQueue.poll());
            if (Math.abs(amount) > answer) {
                answer = Math.abs(amount);
            }
            return;
        }

        for(int i = 0; i < visit.length; i++) {
            if (visit[i]) {
                continue;
            }
            Queue<String> copyQueue = new LinkedList<>();
            for(int j = 0; j < exQueue.size(); j++) {
                String t = exQueue.poll();
                copyQueue.add(t);
                exQueue.add(t);
            }

            Deque<String> nextQueue = new LinkedList<>();
            String target = yun.get(i);

            while(!copyQueue.isEmpty()) {
                String temp = copyQueue.poll();
                // 연산자
                if (temp.contains("*") || temp.contains("+") || temp.contains("-")) {
                    // 우선순위 연산자인 경우
                    if (temp.contains(target)) {
                        long prev = Long.parseLong(nextQueue.removeLast());
                        long next = Long.parseLong(copyQueue.poll());

                        if (temp.contains("*")) {
                            nextQueue.add((prev * next) + "");
                        }
                        else if (temp.contains("+")) {
                            nextQueue.add((prev + next) + "");
                        }
                        else if (temp.contains("-")) {
                            nextQueue.add((prev - next) + "");

                        }
                    }
                    else {
                        nextQueue.add(temp);
                    }
                }
                // 숫자
                else {
                    nextQueue.add(temp);
                }
            }

            visit[i] = true;
            judge(nextQueue, yun, visit, count + 1);
            visit[i] = false;
        }
    }
}
