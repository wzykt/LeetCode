package tanxin;

/**
 * @date  2022-1-14 2022-1-14完成
 * @description 860. 柠檬水找零
 *
 * 参考答案完成
 *
 * 明明要分三种情况去分析，我非要只讨论两种
 */
public class _860 {
    public boolean lemonadeChange(int[] bills) {
        int cash_5 = 0;
        int cash_10 = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                cash_5++;
            }
            if (bills[i] == 10) {
                cash_5--;
                cash_10++;
            }

            if (bills[i] == 20) {
                //贪心，优先消耗10+5这种组合
                if (cash_5 > 0 && cash_10 > 0) {
                    cash_5--;
                    cash_10--;
                } else {
                    cash_5 -= 3;
                }
            }

            if (cash_5 < 0 || cash_10 < 0) {
                return false;
            }
        }
        return true;
    }
}
