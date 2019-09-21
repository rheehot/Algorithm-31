import java.util.*;
public class MiniMaxSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] array = new int[5];
        for(int i = 0; i < 5; i++) {
            array[i] = scan.nextInt();
        }

        Arrays.sort(array);

        int min = array[0] + array[1] + array[2] + array[3];
        int max = array[1] + array[2] + array[3] + array[4];

        System.out.println(min + " " + max);
    }
}