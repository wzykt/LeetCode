package demo;

import java.util.Arrays;

/**
 * 57. 插入区间
 *
 * @date 2021/9/26
 */
public class _57 {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] res = new int[intervals.length + 1][2];
        int[][] ints = Arrays.copyOf(intervals, intervals.length + 1);
        ints[ints.length - 1] = newInterval;
        int[][] merge = merge(ints);
        return merge;
    }

    public static int[][] merge(int[][] intervals) {
        // 先按照区间起始位置排序
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        // 遍历区间
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval : intervals) {
            // 如果结果数组是空的，或者当前区间的起始位置 > 结果数组中最后区间的终止位置，
            // 则不合并，直接将当前区间加入结果数组。
            if (idx == -1 || interval[0] > res[idx][1]) {
                res[++idx] = interval;
            } else {
                // 反之将当前区间合并至结果数组的最后区间
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, idx + 1);
    }

    public static void main(String[] args) {
        int[] newInterval = {2, 5};
        int[][] intervals = {{1, 3}, {6, 9}};
        int[][] merge = insert(intervals, newInterval);
        for (int i = 0; i < merge.length; i++) {
            System.out.println(Arrays.toString(merge[i]));
        }
    }
}
