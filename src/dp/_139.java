package dp;

import java.util.List;

/**
 * @date 2022-2-8
 * @description 139. 单词拆分
 *
 * 遍历顺序
 * 要是外层for循环遍历物品，内层for遍历背包，就需要把所有的子串都预先放在一个容器里。
 * 选择的遍历顺序为：遍历背包放在外循环，将遍历物品放在内循环。内循环从前到后。
 */
public class _139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] valid = new boolean[s.length() + 1];
        valid[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (wordDict.contains(s.substring(j,i)) && valid[j]) {
                    valid[i] = true;
                }
            }
        }

        return valid[s.length()];
    }
}
