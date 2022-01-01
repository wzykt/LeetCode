package huisu;

import java.util.*;

/**
 * @date 2021-12-28 2021-12-28完成
 * @description 17. 电话号码的字母组合
 *
 * 标准回溯代码
 */
public class _17 {

    String[] dic = {"", // 0
            "", // 1
            "abc", // 2
            "def", // 3
            "ghi", // 4
            "jkl", // 5
            "mno", // 6
            "pqrs", // 7
            "tuv", // 8
            "wxyz"};
    List<String> res = new ArrayList<>();
    LinkedList<Character> list = new LinkedList<>();

    public List<String> letterCombinations(String digits) {
        if("".equals(digits)){
            return res;
        }
        int len = digits.length();
        char[] chars = digits.toCharArray();
        backTracking(chars, len, 0);
        return res;
    }

    public void backTracking(char[] cs, int len, int index1) {

        if (list.size() == len) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i));
            }
            res.add(sb.toString());
        }
        for (int i = index1; i < len; i++) {
            String s = dic[Integer.parseInt(cs[i] + "")];
            char[] chars = s.toCharArray();
            for (int j = 0; j < s.length(); j++) {
                list.add(chars[j]);
                backTracking(cs, len, i + 1);
                list.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        _17 obj = new _17();
        List<String> strings = obj.letterCombinations("23");
        System.out.println(strings.toString());
    }
}
