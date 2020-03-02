package BACKJOON;

public class SelfNumber {
    public static void main(String[] args) {

        boolean visit[] = new boolean[10001];

        for(int i = 1; i <= 10000; i++) {
            int sn = getSn(i);
            if(sn <= 10000) {
                visit[sn] = true;
            }
        }

        for(int i = 1; i <= 10000; i++) {
            if (!visit[i]) {
                System.out.println(i);
            }
        }
    }

    private static int getSn(int n) {
        int sn = n;
        while(n > 0) {
            sn += n % 10;
            n /= 10;
        }
        return sn;
    }
}
