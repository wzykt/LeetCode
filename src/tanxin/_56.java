package tanxin;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 56. 合并区间
 *
 * @date 2021/9/26 2021/9/26完成 2022-1-16再次完成
 * @description 参考答案完成，没有把可能出现的情况想全
 */

public class _56 {
//    public static int[][] merge(int[][] intervals) {
//        if (intervals.length == 1) {
//            return intervals;
//        }
//
//        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
    //没过，区间情况没考虑全
//        int index = 0;
//        while (index < intervals.length - 1) {
//            int nowMax = intervals[index][1];
//            if (nowMax >= intervals[index + 1][0]) {
//                int[] t = new int[]{intervals[index][0], intervals[index + 1][1]};
//                intervals[index] = t;
//                intervals[index + 1] = t;
//                index = index + 2;
//            }
//            index++;
//        }
//        List<int[]> collect = Arrays.stream(intervals).distinct().collect(Collectors.toList());
//        int[][] res = new int[collect.size()][2];
//        for (int i = 0; i <res.length ; i++) {
//            res[i] = collect.get(i);
//        }
//        return res;


    //2021/9/26
/*    public static int[][] merge(int[][] intervals) {
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
    }*/


    //2022-1-16
    //可以参考435和452两题
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new LinkedList<>();
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        int start = intervals[0][0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > intervals[i - 1][1]) {
                res.add(new int[]{start, intervals[i - 1][1]});
                start = intervals[i][0];
            } else {
                intervals[i][1] = Math.max(intervals[i][1], intervals[i - 1][1]);
            }
        }
        res.add(new int[]{start, intervals[intervals.length - 1][1]});
        return res.toArray(new int[res.size()][]);
    }
}
