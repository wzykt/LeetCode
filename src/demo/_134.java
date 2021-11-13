package demo;

/**
 * @date 2021/11/8
 * @description
 */
public class _134 {

    public static int canCompleteCircuit(int[] gas, int[] cost) {
       /* //超时 时间复杂度o(n*n)
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
        //当所在位置的油不够时，直接从下一个节点开始判断，并且不需要走一圈
        int totalGas = 0;
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
    }

    public static void main(String[] args) {
//        int[] gas = {1, 2, 3, 4, 5};
//        int[] cost = {3, 4, 5, 1, 2};
        int[] gas = {2, 3, 4};
        int[] cost = {3, 4, 3};
        int i = canCompleteCircuit(gas, cost);
        System.out.println(i);
    }
}
