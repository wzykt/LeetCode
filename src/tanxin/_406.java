package tanxin;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @date 2022-1-14 2022-1-14完成
 * @description 406. 根据身高重建队列
 * 参考答案完成
 * <p>
 * 结论：现根据身高排序，再根据people的k进行插入
 *
 * 可以参考135题，两者都是分情况讨论，不要两个维度一起考虑
 */
public class _406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            //如果身高相同，按people的k来排序
            if (a[0] == b[0]) return a[1] - b[1];
            //不同就按照身高从高到低排序
            return b[0] - a[0];
        });
        LinkedList<int[]> queue = new LinkedList<>();

        for (int[] i : people) {
            queue.add(i[1], i);
        }
        return queue.toArray(new int[people.length][]);
    }
}
