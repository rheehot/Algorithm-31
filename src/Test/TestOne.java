package Test;

// 3번
public class TestOne {

    public String solution(String[] registered_list, String new_id) {
        if (judgeId(registered_list, new_id)) {
            return new_id;
        }
        String s = new_id;
        String n = "0";
        for(int i = 0; i < new_id.length(); i++) {
            if(new_id.charAt(i) < 58) {
                n = new_id.substring(i);
                s = new_id.substring(0, i);
                break;
            }
        }

        int num = Integer.parseInt(n);
        while(true) {
            num++;
            if(judgeId(registered_list, s+num)) {
                return s+num;
            }
            else {
                continue;
            }
        }
    }

    public boolean judgeId(String[] registered_list, String id) {
        for(int i = 0; i < registered_list.length; i++) {
            if(registered_list[i].equals(id)) {
                return false;
            }
        }
        return true;
    }
}
