package demo;

import java.util.*;

/**
 * 6. Z 字形变换
 *
 * @date 2021/9/24
 * @description 第一行每隔1，3，5....从字符串中取字符，其他行取上一行左右相邻的字符,use用来记录已经使用过的字符
 */
public class _6 {
    //代码无法解决第一行只有一个字母的情况
//    public static String convert(String s, int numRows) {
//        if (numRows == 1) {
//            return s;
//        }
//        int interval = (numRows - 2) * 2 + 2;
//        char[] chars = s.toCharArray();
//        Deque deque = new LinkedList();
//        StringBuffer sb = new StringBuffer();
//        Set<Integer> use = new HashSet<>();
//        for (int i = 0; i < s.length(); i += interval) {
//            deque.add(i);
//            use.add(i);
//        }
//        while (!deque.isEmpty()) {
//            int t = (int) deque.removeFirst();
//            sb.append(chars[t]);
//            if (!use.contains(t - 1) && t - 1 >= 0) {
//                deque.add(t - 1);
//                use.add(t - 1);
//            }
//            if (!use.contains(t + 1) && t + 1 < chars.length) {
//                deque.add(t + 1);
//                use.add(t + 1);
//            }
//        }
//        return sb.toString();
//    }

    //参考答案https://leetcode-cn.com/problems/zigzag-conversion/solution/zzi-xing-bian-huan-by-jyd/
    //灵活的使用flag标志位
    //if(i == 0 || i == numRows -1) flag = - flag;这行代码是精髓
    public static String convert(String s, int numRows) {
        if(numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for(int i = 0; i < numRows; i++) rows.add(new StringBuilder());
        int i = 0, flag = -1;
        for(char c : s.toCharArray()) {
            rows.get(i).append(c);
            if(i == 0 || i == numRows -1) flag = - flag;
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows) res.append(row);
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 4;
        String convert = convert(s, numRows);
        System.out.println(convert);
    }
}
