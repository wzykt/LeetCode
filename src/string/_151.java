package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @date 2021-12-20 2021-12-20完成
 * @description 151. 翻转字符串里的单词
 *
 * 这里没有使用
 * trim(),Collections.reverse(),split("\\s+")API
 *
 * split("\\s+")这里用来去除空格
 */
public class _151 {

    //自定义API和官方执行效率相同
    public static String reverseWords(String s) {
        if (s == null) {
            return null;
        }
        List<String> list = new ArrayList<>();
        //
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            String t = s.substring(i, i + 1);
            if (" ".equals(t)) {
                if(len != 0){
                    list.add(s.substring(i - len, i));
                    len = 0;
                    continue;
                }
                len = 0;
                continue;
            }
            len++;
            if(i == s.length() -1){
                list.add(s.substring(i - len + 1, i + 1));
            }
        }
        //System.out.println(list.toString());
        int l = 0;
        int r = list.size() - 1;
        while (l < r) {
            String t = list.get(l);
            list.set(l,list.get(r));
            list.set(r,t);
            l++;
            r--;
        }
        System.out.println(list.toString());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                sb.append(list.get(i));
                break;
            }
            sb.append(list.get(i));
            sb.append(" ");
        }
        return sb.toString();
    }
    //借助API来完成
   /* public String reverseWords(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }*/

    public static void main(String[] args) {
        String s = "  hello world  ";
        System.out.println(reverseWords(s));
    }
}
