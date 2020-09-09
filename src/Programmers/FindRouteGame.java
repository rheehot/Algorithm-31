package Programmers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class FindRouteGame {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] nodeinfo = {{5, 3},{11, 5},{13, 3},{3, 5},{6, 1},{1, 3},{8, 6},{7, 2},{2, 2}};
        solution(nodeinfo);
        bw.flush();
        bw.close();
    }

    public static int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];
        RouteNode[] nodeArr = new RouteNode[nodeinfo.length];

        for(int i = 0; i< nodeinfo.length; i++) {
            nodeArr[i] = new RouteNode(nodeinfo[i][0], nodeinfo[i][1], i + 1);
        }

        Arrays.sort(nodeArr, new Comparator<RouteNode>() {
            @Override
            public int compare(RouteNode o1, RouteNode o2) {
                if(o1.y == o2.y) {
                    return o1.x - o2.x;
                }
                return o2.y - o1.y;
            }
        });

        // 트리 구성
        RouteNode root = nodeArr[0];
        for(int i = 1; i < nodeinfo.length; i++) {
            searchAndInsert(root, nodeArr[i]);
        }

        List<Integer> list = new LinkedList<>();
        // 전위순회
        preOrder(root, list);
        for(int i = 0; i < list.size(); i++) {
            answer[0][i] = list.get(i);
        }
        list.clear();
        // 후위순회
        postOrder(root, list);
        for(int i = 0; i < list.size(); i++) {
            answer[1][i] = list.get(i);
        }

        return answer;
    }

    public static void searchAndInsert(RouteNode root, RouteNode insertNode) {
        // 왼쪽에 삽입
        if(root.x > insertNode.x) {
            if(root.left != null) {
                searchAndInsert(root.left, insertNode);
            }
            else {
                root.left = insertNode;
            }
        }
        // 오른쪽에 삽입
        else {
            if(root.right != null) {
                searchAndInsert(root.right, insertNode);
            }
            else {
                root.right = insertNode;
            }
        }
    }

    public static void preOrder(RouteNode root, List<Integer> list) {
        list.add(root.index);

        if(root.left != null) {
            preOrder(root.left, list);
        }

        if(root.right != null) {
            preOrder(root.right, list);
        }
    }

    public static void postOrder(RouteNode root, List<Integer> list) {
        if(root.left != null) {
            postOrder(root.left, list);
        }
        if(root.right != null) {
            postOrder(root.right, list);
        }
        list.add(root.index);
    }
}

class RouteNode {
    int x;
    int y;
    int index;
    RouteNode left = null;
    RouteNode right = null;

    RouteNode(int x, int y, int index) {
        this.x = x;
        this.y = y;
        this.index = index;
    }
}