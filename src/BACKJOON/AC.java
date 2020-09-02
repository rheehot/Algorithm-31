package BACKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class AC {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arr = br.readLine();
            arr = arr.substring(1, arr.length() - 1);

            String[] a = arr.split(",");
            ArrayList<Integer> list = new ArrayList<>();
            for(int j = 0; j < a.length; j++) {
                if(a[j].equals("")) {
                    continue;
                }
                list.add(Integer.parseInt(a[j]));
            }

            boolean isReverse = false;
            boolean isError = false;
            for(int index = 0; index < p.length(); index++) {
                if(p.charAt(index) == 'R') {
                    isReverse = !isReverse;
                }
                else {
                    if(list.isEmpty()) {
                        sb.append("error\n");
                        isError = true;
                        break;
                    }
                    else {
                        if(isReverse) {
                            list.remove(list.size() - 1);
                        }
                        else {
                            list.remove(0);
                        }
                    }
                }
            }

            if(isError) {
                continue;
            }

            sb.append("[");
            int size = list.size();
            if(isReverse) {
                for(int s = size - 1; s >= 0; s--) {
                    sb.append(list.get(s));
                    if(s != 0) {
                        sb.append(",");
                    }
                }
            }
            else {
                for(int s = 0; s < size; s++) {
                    sb.append(list.get(s));
                    if(s != size - 1) {
                        sb.append(",");
                    }
                }
            }

            sb.append("]\n");
        }

        System.out.println(sb);
    }
}
