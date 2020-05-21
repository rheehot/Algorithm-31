package Programmers;

import java.util.ArrayList;

public class Paper {
    public int[] solution(int n) {
        int[] papers = new int[(int)Math.pow(2, n)];
        ArrayList<Integer> ans = new ArrayList<>();

        papers[1] = 0;
        for(int i = 1; i < (int)Math.pow(2, n -1); i++) {
            papers[2 * i] = 0;
            papers[2 * i + 1] = 1;
        }

        inOrder(papers, 1, ans);

        int[] answer = new int[ans.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = ans.get(i);
        }

        return answer;
    }

    private void inOrder(int[] papers, int idx, ArrayList<Integer> ans) {
        if(idx * 2 < papers.length) {
            inOrder(papers, idx * 2, ans);
        }
        ans.add(papers[idx]);
        if(idx * 2 + 1 < papers.length) {
            inOrder(papers, idx * 2 + 1, ans);
        }
    }
}
