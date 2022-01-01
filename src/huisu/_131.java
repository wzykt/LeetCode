package huisu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @date 2021-12-30 2021-12-30完成
 * @description 131. 分割回文串
 *
 * 想要获取字符串可以获取字符串的下标，之后再调用substring方法截取即可
 *
 * 向中间集合存放数据时，并不是每一次都放进集合中，也可以符合某些条件再放进集合
 */
public class _131 {

    List<List<String>> res = new ArrayList<>();
    LinkedList<String> list = new LinkedList<>();

    public List<List<String>> partition(String s) {
        backTracking(s, 0);
        return res;
    }

    public void backTracking(String s, int index) {
        if (index >= s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }


        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                String str = s.substring(index, i + 1);
                list.addLast(str);
            } else {
                continue;
            }
            backTracking(s, i + 1);
            list.removeLast();
        }

    }

    private boolean isPalindrome(String s, int startIndex, int end) {
        for (int i = startIndex, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        _131 obj = new _131();
        String s = "aab";
        System.out.println(obj.partition(s));
    }

}
