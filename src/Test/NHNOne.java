package Test;

import java.util.ArrayList;
import java.util.List;

public class NHNOne {
    public static void main(String[] args) throws Exception {
        char[] name = {'B', 'C'};
        int[] game = {3, -2};
        solution(6, 2, name, 2, game);
    }

    static People cur;
    static int curIndex = 0;
    static List<People> peopleList = new ArrayList<>();
    static List<Character> fastList = new ArrayList<>();
    public static void solution(int numOfAllPlayers, int numOfQuickPlayers, char[] namesOfQuickPlayers, int numOfGames, int[] numOfMovesPerGame) {
        cur = new People('A', 1);

        for(int i = 0; i < numOfAllPlayers - 1; i++) {
            char name = (char)(i + 'B');
            peopleList.add(i, new People(name, 0));
        }

        for(int i = 0; i < numOfQuickPlayers; i++) {
            fastList.add(namesOfQuickPlayers[i]);
        }

        for(int i = 0; i < numOfGames; i++) {
            game(numOfMovesPerGame[i]);
        }

        for(int i = 0; i < peopleList.size(); i++) {
            People temp = peopleList.get(i);
            System.out.println(temp.name + " " + temp.count);
        }
        System.out.println(cur.name + " " + cur.count);
    }

    public static void game(int dir) {
        int tempIndex = curIndex;
        tempIndex += dir;
        if(tempIndex < 0) {
            tempIndex = Math.abs(tempIndex);
            tempIndex %= peopleList.size();
            tempIndex = peopleList.size() - tempIndex;
        }
        if(tempIndex >= peopleList.size()) {
            tempIndex %= peopleList.size();
        }

        char tempName = peopleList.get(tempIndex).name;
        if(fastList.contains(tempName)) {
            cur.count++;
            curIndex = tempIndex;
            return;
        }

        People next = peopleList.remove(tempIndex);

        peopleList.add(tempIndex, cur);

        next.count++;
        cur = next;

        curIndex = tempIndex;
    }
}

class People {
    char name;
    int count;
    boolean fast;

    People(char name, int count) {
        this.name = name;
        this.count = count;
        this.fast = false;
    }
}
