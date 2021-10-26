package demo;

/**
 * 122. 买卖股票的最佳时机 II
 *
 * @date 2021/10/26开始 2021/10/26完成
 */
public class _122 {
    //记录每一次上升区间的差值之和即可
    public static int maxProfit(int[] prices) {
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


    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int i = maxProfit(prices);
        System.out.println(i);
    }
}
