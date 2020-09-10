package Programmers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Kakao2019Route {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] nodeinfo = new int[n][2];
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            nodeinfo[i][0] = Integer.parseInt(st.nextToken());
            nodeinfo[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] result = solution(nodeinfo);
        for(int i = 0; i < result.length; i++) {
            for(int j = 0; j < result[0].length; j++) {
                bw.write(result[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    public static int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];
        RouteIndex[] indexArr = new RouteIndex[nodeinfo.length];

        for(int i = 0; i < nodeinfo.length; i++) {
            indexArr[i] = new RouteIndex(nodeinfo[i][0], nodeinfo[i][1], i + 1);
        }

        Arrays.sort(indexArr, new Comparator<RouteIndex>() {
            @Override
            public int compare(RouteIndex o1, RouteIndex o2) {
                if(o1.y == o2.y) {
                    return o1.x - o2.x;
                }
                return o1.y - o2.y;
            }
        });

        //트리 구성
        RouteIndex root = indexArr[0];
        for(int i = 1; i < indexArr.length; i++) {
            searchAndInsert(root, indexArr[i]);
        }

        List<Integer> list = new ArrayList<>();
        preOrder(root, list);
        for(int i = 0; i < list.size(); i++) {
            answer[0][i] = list.get(i);
        }

        list.clear();
        postOrder(root, list);
        for(int i = 0; i < list.size(); i++) {
            answer[1][i] = list.get(i);
        }

        return answer;
    }

    public static void searchAndInsert(RouteIndex root, RouteIndex target) {
        // 왼쪽
        if(root.x > target.x) {
            if(root.left != null) {
                searchAndInsert(root.left, target);
            }
            else {
                root.left = target;
            }
        }
        // 오른쪽
        else {
            if(root.right != null) {
                searchAndInsert(root.right, target);
            }
            else {
                root.right = target;
            }
        }
    }

    public static void preOrder(RouteIndex root, List<Integer> list) {
        list.add(root.index);
        if(root.left != null) {
            preOrder(root.left, list);
        }
        if(root.right != null) {
            preOrder(root.right, list);
        }
    }

    public static void postOrder(RouteIndex root, List<Integer> list) {
        if(root.left != null) {
            postOrder(root.left, list);
        }
        if(root.right != null) {
            postOrder(root.right, list);
        }
        list.add(root.index);
    }

}
class RouteIndex{
    int x;
    int y;
    int index;

    RouteIndex right;
    RouteIndex left;

    RouteIndex(int x, int y, int index) {
        this.x = x;
        this.y = y;
        this.index = index;
    }
}
