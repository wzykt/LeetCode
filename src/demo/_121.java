package demo;

/**
 * 121. 买卖股票的最佳时机
 *
 * @date 2021/10/26
 * @description 属于我看了好多次的题目，但是一直没什么思路
 * 双指针超时
 *
 * 参考https://www.bilibili.com/video/BV1wA411b7qZ?p=21
 */
public class _121 {
    public static int maxProfit(int[] prices) {
        //暴力方式
       /* int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if(prices[i] > prices[j]){
                    continue;
                }
                max = Math.max(max, prices[i] - prices[j]);
            }
        }
        return max;*/

        //正确答案
        /*
        找到每个点左半区的最小值，计算当前节点差的最大值
         */
        //min时刻记录这左边区的最小值
        int min = prices[0];
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            //prices[i] < min可以表示股价再跌，肯定没有最大利润
            if (prices[i] < min) {
                min = prices[i];
            } else if (max < prices[i] - min) {
                max = prices[i] - min;
            }
        }
        return max;
    }

    public static int process(int i, int[] prices) {
        if (i == prices.length - 1) {
            return 0;
        }
        int r = 0;
        for (int j = i + 1; j < prices.length; j++) {
            r = Math.max(prices[j] - prices[i], r);
        }
        r = Math.max(r, process(i + 1, prices));
        return r;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int i = maxProfit(prices);
        System.out.println(i);
    }
}
