package tanxin;

import java.util.Arrays;

/**
 * @date 2022-1-10 2022-1-10完成
 * @description 455. 分发饼干
 */
public class _455 {
    public int findContentChildren(int[] g, int[] s) {
        if (s.length == 0) {
            return 0;
        }
        int count = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int slen = s.length - 1;
        for (int i = g.length - 1; i >= 0; i--) {
            if (slen >= 0 && s[slen] >= g[i]) {
                slen--;
                count++;
            }
        }
        return count;
    }

}
