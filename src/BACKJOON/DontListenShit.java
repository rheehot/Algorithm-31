package BACKJOON;

import java.util.*;

public class DontListenShit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();

        scan.nextLine();
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < N; i++) {
            set.add(scan.nextLine());
        }

        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            String temp = scan.nextLine();
            if(set.contains(temp)) {
                list.add(temp);
            }
        }

        System.out.println(list.size());
        Collections.sort(list);
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
