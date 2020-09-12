package BACKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BestSeller {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++) {
            String title = br.readLine();
            if(map.containsKey(title)) {
                map.put(title, map.get(title) + 1);
            }
            else {
                map.put(title, 1);
            }
        }

        Queue<Book> q = new PriorityQueue<>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                if(o1.count == o2.count) {
                    return o1.title.compareTo(o2.title);
                }
                return o2.count - o1.count;
            }
        });

        String[] key = map.keySet().toArray(new String[map.size()]);
        for(int i = 0; i < key.length; i++) {
            q.offer(new Book(key[i], map.get(key[i])));
        }

        bw.write(q.poll().title);


        bw.flush();
        bw.close();
    }
}
class Book {
    String title;
    int count;

    Book(String title, int count) {
        this.title = title;
        this.count = count;
    }
}