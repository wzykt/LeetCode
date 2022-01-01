package huisu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @date 2021-12-28 2021-12-28完成
 * @description 216. 组合总和 III
 *
 * 标准模板完成
 */
public class _216 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(k, n, 0);
        return res;
    }

    public void backTracking(int k, int n, int index) {
        if (sum(list) > n || list.size() > k) {
            return;
        }
        if (sum(list) == n && list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index + 1; i < 10; i++) {
            list.add(i);
            backTracking(k, n, i + 1);
            list.removeLast();
        }
    }

    public int sum(List<Integer> list) {
        int sum = 0;
        for (Integer i : list) {
            sum += i;
        }
        return sum;
    }
}
