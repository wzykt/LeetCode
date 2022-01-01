package huisu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @date 2021-12-30 2021-12-30完成
 * @description 93. 复原 IP 地址
 */
public class _93 {
    List<String> res = new ArrayList<>();
    LinkedList<String> list = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {
        backTracking(s, 0);
        return res;
    }


    public void backTracking(String s, int index) {
        if (index == s.length()) {
            if (isIp(list, s.length())) {
                res.add(to(list));
            }
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (i - index + 1 <= 3) {
                list.addLast(s.substring(index, i + 1));
            } else {
                continue;
            }
            backTracking(s, i + 1);
            list.removeLast();
        }
    }

    public boolean isIp(LinkedList<String> list, int len) {
        if (list.size() != 4) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            int i1 = Integer.parseInt(list.get(i));
            if (i1 > 255) {
                return false;
            }
            int l = String.valueOf(i1).length();
            if (l < list.get(i).length()) {
                return false;
            }
        }
        return true;
    }

    public String to(LinkedList<String> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append(".");
        }
        return sb.delete(sb.length() - 1, sb.length()).toString();
    }

    public static void main(String[] args) {
        _93 obj = new _93();
        String s = "101023";
        obj.restoreIpAddresses(s);
        System.out.println(obj.res.toString());
    }
}
