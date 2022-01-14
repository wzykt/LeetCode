package tanxin;

import java.util.Arrays;

/**
 * 122. 买卖股票的最佳时机 II
 *
 * @date 2021/10/26开始 2021/10/26完成  2022-1-13再次完成
 */
public class _122 {
    //记录每一次上升区间的差值之和即可
    /*public static int maxProfit(int[] prices) {
        int sale = 0;
        int buy = 0;
        int index = 1;
        int max = 0;
        while (index < prices.length) {
            if (index == prices.length - 1) {
                if (prices[sale] < prices[index]) {
                    sale = index;
                }max += prices[sale] - prices[buy];
                index++;
            } else if (prices[sale] > prices[index]) {
                max += prices[sale] - prices[buy];
                index++;
                sale++;
                buy = sale;
            } else {
                index++;
                sale++;
            }
        }
        return max;
    }
*/

    //贪心
    //上升区间的差值
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int[] ints = Arrays.copyOf(prices, prices.length + 1);

        int count = 0;

        int sum = 0;

        for (int i = 0; i < ints.length - 1; i++) {
            if (ints[i] <= ints[i + 1]) {
                count++;
            } else {
                sum += ints[i] - ints[i - count];
                count = 0;
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        int[] prices = {3, 1};
        _122 obj = new _122();
        int i = obj.maxProfit(prices);
        System.out.println(i);
    }
}
