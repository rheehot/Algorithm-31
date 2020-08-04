package Programmers;

import java.util.Arrays;
import java.util.Scanner;

public class marathon {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int pNum = scan.nextInt();
        String[] participant = new String[pNum];
        scan.nextLine();
        for(int i = 0; i < pNum; i++) {
            participant[i] = scan.nextLine();
        }

        int cNum = scan.nextInt();
        String[] completion = new String[cNum];
        scan.nextLine();
        for(int i = 0; i < cNum; i++) {
            completion[i] = scan.nextLine();
        }

        solution(participant, completion);
    }

    public static String solution(String[] participant, String[] completion) {

        Arrays.sort(participant);
        Arrays.sort(completion);

        int index = 0;
        for(String c : completion) {
            if(!c.equals(participant[index])) {
                return participant[index];
            }
            index++;
        }

        return participant[participant.length - 1];
    }
}
