package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Lotto {
    static List<String> answer = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            String str = br.readLine();
            if(str.equals("0")) {
                break;
            }

            StringTokenizer st = new StringTokenizer(str);
            int K = Integer.parseInt(st.nextToken());
            int[] nums = new int[K];
            for(int i = 0; i < K; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }
            answer.clear();
            solution(nums, 0, 0, "");
            String[] a = answer.toArray(new String[answer.size()]);

            for(int index = 0; index < a.length; index++) {
                bw.write(a[index] + "\n");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    public static void solution(int[] nums, int count, int index, String result) {
        if(index >= nums.length) {
            if(count == 6) {
                answer.add(result);
            }
            return;
        }

        String r = result + nums[index] + " ";
        solution(nums, count + 1, index + 1, r);
        solution(nums, count, index + 1, result);

    }
}
