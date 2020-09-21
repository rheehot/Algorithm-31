package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class MakeSecret {
    static int L, C;
    static String[] str;
    static List<String> answer = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        str = new String[C];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < C; i++) {
            str[i] = st.nextToken();
        }
        Arrays.sort(str);
        choice(0, "", 0);

        Collections.sort(answer);
        for(int i = 0; i < answer.size(); i++) {
            bw.write(answer.get(i) + "\n");
        }

        bw.flush();
        bw.close();
    }

    public static void choice(int index, String r, int count) {
        if(index == str.length) {
            if(count == L && check(r)) {
                answer.add(r);
            }
            return;
        }

        choice(index + 1, r + str[index], count + 1);
        choice(index + 1, r, count);
    }

    public static boolean check(String r) {
        int mo = 0;
        int ja = 0;
        for(int i = 0; i < r.length(); i++) {
            char temp = r.charAt(i);

            if(temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o' || temp == 'u') {
                mo++;
            }
            else {
                ja++;
            }
        }

        boolean answer = false;
        if(mo >= 1 && ja >= 2) {
            answer = true;
        }

        return answer;
    }
}
