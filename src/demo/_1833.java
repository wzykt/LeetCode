package demo;

import java.util.Arrays;

/**
 * 1833. 雪糕的最大数量
 *
 * @date 2021/8/28开始，2021/8/28完成
 * @description 首先想到的是贪心，拍好顺序后，比较价格即可
 */
public class _1833 {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int num = 0;
        int t = 0;
        for (int i = 0; i < costs.length; i++) {
            t += costs[i];
            if (t <= coins) {
                num++;
            }else {
                break;
            }
        }
        return num;
    }
}
