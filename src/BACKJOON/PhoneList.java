package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PhoneList {
    static class PhoneTrie {
        boolean isEndWord;
        PhoneTrie children[];

        PhoneTrie() {
            isEndWord = false;
            children = new PhoneTrie[10];

            for(int i = 0; i < 10; i++) {
                children[i] = null;
            }
        }
    }

    static PhoneTrie root;

    static void insert(String key) {
        PhoneTrie curTrie = root;
        int length = key.length();
        int level;
        int index;

        for(level = 0; level < length; level++) {
            index = key.charAt(level) - '0';
            if(curTrie.children[index] == null) {
                curTrie.children[index] = new PhoneTrie();
            }

            curTrie = curTrie.children[index];
        }

        curTrie.isEndWord = true;
    }

    static boolean available(String key) {
        PhoneTrie curTrie = root;
        int length = key.length();
        int level;
        int index;

        for(level = 0; level < length; level++) {
            index = key.charAt(level) - '0';
            if(curTrie.isEndWord) {
                return false;
            }

            curTrie = curTrie.children[index];
        }

        return true;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            root = new PhoneTrie();
            String[] list = new String[n];
            for(int j = 0; j < n; j++) {
                list[j] = br.readLine();
                insert(list[j]);
            }

            boolean ans = true;
            for(int j = 0; j < n; j++) {
                if(!available(list[j])) {
                    ans = false;
                    break;
                }
            }

            if(ans) {
                bw.write("YES\n");
            }
            else {
                bw.write("NO\n");
            }
        }

        bw.flush();
        bw.close();
    }
}