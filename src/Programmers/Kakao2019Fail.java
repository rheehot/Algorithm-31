package Programmers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

// 14:20 - 14:45
public class Kakao2019Fail {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] stages = new int[m];
        for(int i = 0; i < m; i++) {
            stages[i] = Integer.parseInt(br.readLine());
        }
        int[] answer = solution(N, stages);

        for(int i = 0; i < answer.length; i++) {
            bw.write(answer[i] + "\n");
        }

        bw.flush();
        bw.close();
    }

    public static int[] solution(int N, int[] stages) {
        double[] failStages = new double[N + 2];
        double people = stages.length;
        for(int i = 0; i < people; i++) {
            failStages[stages[i]]++;
        }

        Queue<FailIndex> q = new PriorityQueue<>(new Comparator<FailIndex>() {
            @Override
            public int compare(FailIndex o1, FailIndex o2) {
                if(o1.fail == o2.fail) {
                    return o1.stageIndex-o2.stageIndex;
                }
                return Double.compare(o2.fail, o1.fail);
            }
        });

        for(int i = 1; i <= N; i++) {
            if(people == 0) {
                q.offer(new FailIndex(i, 0.0));
                continue;
            }
            double fail = failStages[i] / people;
            q.offer(new FailIndex(i, fail));
            people -= failStages[i];
        }

        int[] answer = new int[N];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = q.poll().stageIndex;
        }
        return answer;
    }

}
class FailIndex {
    int stageIndex;
    double fail;

    FailIndex(int stageIndex, double fail) {
        this.stageIndex = stageIndex;
        this.fail = fail;
    }
}
