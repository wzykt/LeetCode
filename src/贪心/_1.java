package 贪心;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

/**
 * 给定一个由字符串组成的数组strs,
 * 必须把所有的字符串拼接起来，
 * 返回所有可能的拼接结果中，字典序最小的结果
 *
 * eg：字典序
 */
public class _1 {


    //strs里放着所有的字符串
    //已经使用过的字符串，在use里登记了，不要再使用了
    //之前使用过的字符串，拼接成了-> path
    //用all收集所有可能的拼接结果
    //dfs全排列,时间复杂度 o(n!)
    public static void process(String[] strs,HashSet<Integer> use, String path, ArrayList<String> res){
        if(use.size() == strs.length){
            res.add(path);
        }

        for (int i = 0; i < strs.length; i++) {
            if(!use.contains(i)){
                use.add(i);
                process(strs, use, path + strs[i], res);
                use.remove(i);
            }
        }
    }

    //贪心，a.b字典序 < b.a字典序 true：a 在前，false b 在前
    //compare方法比较两个字符串就是比较字典序
    public static class MyComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            return (a + b).compareTo(b + a);
        }
    }
    public static String lowestString2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        Arrays.sort(strs, new MyComparator());
        String res = "";
        for (int i = 0; i < strs.length; i++) {
            res += strs[i];
        }
        return res;
    }

}
