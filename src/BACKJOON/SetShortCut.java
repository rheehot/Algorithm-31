package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

// 15:00 - 15:30
public class SetShortCut {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            bw.write(solution(str));
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    static HashSet<Character> set = new HashSet<>();
    public static String solution(String str) {
        String change = str.toUpperCase();

        StringTokenizer st = new StringTokenizer(change);
        String[] words = new String[st.countTokens()];
        for(int index = 0; index < words.length; index++) {
            words[index] = st.nextToken();
        }
        // 단어의 첫번째 가능?
        for(int index = 0; index < words.length; index++) {
            char temp = words[index].charAt(0);
            if(!set.contains(temp)) {
                set.add(temp);
                if(index == 0) {
                    return edit(str, 0);
                }
                else {
                    int count = 0;
                    for(int i = 0; i < index; i++) {
                        count += (words[i].length() + 1);
                    }
                    return edit(str, count);
                }
            }
        }

        // 단어의 첫번째 글자 아님
        for(int i = 0; i < str.length(); i++) {
            char temp = change.charAt(i);
            if(!set.contains(temp) && temp != ' ') {
                set.add(temp);
                return edit(str, i);
            }
        }

        // 대표 알파벳 없음
        return str;
    }

    public static String edit(String str, int index) {
        String answer = "";
        for(int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            if(i == index) {
                answer += "[";
                answer += temp;
                answer += "]";
                continue;
            }
            answer += temp;
        }
        return answer;
    }
}
