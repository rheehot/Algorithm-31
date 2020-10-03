package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ1525 {
    static String target = "123456780";
    static HashSet<String> set = new HashSet<>();
    static ArrayList<Integer>[] indexList = new ArrayList[9];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 0; i < 9; i++) {
            indexList[i] = new ArrayList<>();
        }

        indexList[0].add(1);
        indexList[0].add(3);

        indexList[1].add(0);
        indexList[1].add(2);
        indexList[1].add(4);

        indexList[2].add(1);
        indexList[2].add(5);

        indexList[3].add(0);
        indexList[3].add(4);
        indexList[3].add(6);

        indexList[4].add(1);
        indexList[4].add(3);
        indexList[4].add(5);
        indexList[4].add(7);

        indexList[5].add(2);
        indexList[5].add(4);
        indexList[5].add(8);

        indexList[6].add(3);
        indexList[6].add(7);

        indexList[7].add(4);
        indexList[7].add(6);
        indexList[7].add(8);

        indexList[8].add(5);
        indexList[8].add(7);

        StringTokenizer st;
        String start = "";
        int index = -1;
        for(int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                String temp = st.nextToken();
                if(temp.equals("0")) {
                    index = i * 3 + j;
                }

                start += temp;
            }
        }
        set.add(start);
        int answer = move(start, index);

        bw.write(answer + "");
        bw.flush();
        bw.close();
    }

    static int move(String start, int index) {
        int count = 0;
        Queue<PuzzleNode> q = new LinkedList<>();
        q.offer(new PuzzleNode(start, index));

        while(!q.isEmpty()) {
            int size = q.size();
            for(int s = 0; s < size; s++) {
                PuzzleNode temp = q.poll();
                if(temp.str.equals(target)) {
                    return count;
                }

                int tempIndex = temp.index;

                for(int i = 0; i < indexList[tempIndex].size(); i++) {
                    int nextIndex = indexList[tempIndex].get(i);
                    String next = change(temp.str, temp.index, nextIndex);

                    if(!set.contains(next)) {
                        set.add(next);
                        q.offer(new PuzzleNode(next, nextIndex));
                    }
                }
            }
            count++;
        }

        return -1;
    }

    static String change(String origin, int zeroIndex, int nextIndex) {
        char next = origin.charAt(nextIndex);
        origin = origin.replace('0', next);
        String answer = origin.substring(0, nextIndex);
        answer += "0";
        answer += origin.substring(nextIndex + 1);

        return answer;
    }
}

class PuzzleNode {
    String str;
    int index;

    PuzzleNode(String str, int index) {
        this.str = str;
        this.index = index;
    }
}
