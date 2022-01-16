package tanxin;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 2022-1-16 2022-1-16完成
 * @description 763.划分字母区间
 *
 * 参考答案完成
 * https://programmercarl.com/0763.%E5%88%92%E5%88%86%E5%AD%97%E6%AF%8D%E5%8C%BA%E9%97%B4.html#%E6%80%9D%E8%B7%AF
 * https://leetcode-cn.com/problems/partition-labels/solution/shou-hua-tu-jie-hua-fen-zi-mu-qu-jian-ji-lu-zui-yu/
 * 结合这两个文章来看
 */
public class _763 {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int[] loc = new int[26];
        for (int i = 0; i < s.length(); i++) {
            loc[s.charAt(i) - 'a'] = i;
        }

        int bound = 0;
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            bound = Math.max(bound, loc[s.charAt(i) - 'a']);
            if (bound == i) {
                res.add(bound - len + 1);
                len = bound + 1;
            }
        }
        return res;
    }
}
