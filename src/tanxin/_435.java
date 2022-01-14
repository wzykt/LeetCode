package tanxin;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @date 2022-1-14 2022-1-14完成
 * @description 435. 无重叠区间
 *
 * 这题不参考答案完全不会
 */
public class _435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length < 2) return 0;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) {
                    return Integer.compare(o1[1], o2[1]);
                } else {
                    return Integer.compare(o1[0], o2[0]);
                }
            }
        });

        int count = 1;
        int edge = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (edge <= intervals[i][0]) {
                count++; //non overlap + 1
                edge = intervals[i][1];
            }
        }
        return intervals.length - count;
    }

}
