package tanxin;

/**
 * @date 2021/11/8 2021/11/8完成 2022-1-14再次完成
 * @description 134. 加油站
 *
 * 结论：如果加油站油的数量小于需要消耗的油的数量，直接-1
 * 否则，判断剩下有的油+当前加油站的油-需要消耗的油是否大于零，大于直接返回当前下标
 */
public class _134 {

    /*public static int canCompleteCircuit(int[] gas, int[] cost) {
        //超时 时间复杂度o(n*n)
        //起始位置
        int begin = -1;
        int index = 0;
        //剩余的油
        int oil = 0;
        int len = gas.length;
        for (int i = 0; i < len; i++) {
            if (gas[i] >= cost[i]) {
                begin = i;
                for (int j = 0; j < len; j++) {
                    index = (begin + j) % len;
                    oil = oil + gas[index] - cost[index];
                    if (oil < 0) {
                        begin = -1;
                        i = index+1;
                        break;
                    }
                    if (j == len - 1) {
                        return begin;
                    }
                }
            }
            oil = 0;
        }
        return begin;*/

    //o(n)
    //2021/11/8
    //当所在位置的油不够时，直接从下一个节点开始判断，并且不需要走一圈
/*        int totalGas = 0;
        int totalCost = 0;
        int len = gas.length;
        for (int i = 0; i < len; i++) {
            totalCost += cost[i];
            totalGas += gas[i];
        }
        if (totalCost > totalGas) {
            return -1;
        }

        int currentGas = 0;
        int start = 0;
        for (int i = 0; i < len; i++) {
            currentGas = currentGas - cost[i] + gas[i];
            if (currentGas < 0) {
                currentGas = 0;
                start = i + 1;
            }
        }
        return start;
    */

    //2022-1-14再次完成
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int min = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += (gas[i] - cost[i]);
            min = Math.min(sum, min);
        }

        if (sum < 0) return -1;
        if (min >= 0) return 0;

        for (int i = gas.length - 1; i > 0; i--) {
            min += (gas[i] - cost[i]);
            if (min >= 0) return i;
        }

        return -1;
    }
}
