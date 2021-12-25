package hash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @date 2021-12-18
 * @description 202. 快乐数
 * <p>
 * 不会解，主要是因为不知道如何退出循环。
 * <p>
 * 答案：
 * 只要出现相同的值，就可以退出循环了，相当于成环了
 * <p>
 * Q:这么多次会不会超时？
 * A:不会，一定不会出现死循环，因为int类型最大值为2 147 483 647， 所以平方和最大的数是1 999 999 999，平方和为1 + 81*9 = 724。
 * 任何数的平方和都在1到724之间，724次循环之内要么有重复的，要么存在1
 */
public class _202 {

    public static boolean isHappy(int n) {
        int index = n;
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        while (!set.contains(index)) {
            set.add(index);
            while (index > 0) {
                list.add(index % 10);
                index = index / 10;
            }
            index = sum(list);
            list.clear();
            if (index == 1) {
                return true;
            }
        }
        return false;
    }

    public static int sum(List<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i) * list.get(i);
        }
        return sum;
    }


    //答案
    //https://leetcode-cn.com/problems/happy-number/solution/kuai-le-shu-by-leetcode-solution/
    /*public int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public boolean isHappy(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }
        return fastRunner == 1;
    }*/
}
