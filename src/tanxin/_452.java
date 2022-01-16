package tanxin;

import java.util.Arrays;

/**
 * @date 2022-1-16 2022-1-16完成
 * @description 452. 用最少数量的箭引爆气球
 *
 * 结论：先进行从大到小的排序，如果当前气球的左边界大于上一个气球的右边界，箭的数量加一，否则更新当前节点的右边界为上一个气球的右边界（主要是用来减少操作）
 *
 * 建议结合435题一起看，都是关于区间的，都是先排序在观察左右边界
 */
public class _452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        int count = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > points[i - 1][1]) {
                count++;
            } else {
                points[i][1] = Math.min(points[i][1],points[i - 1][1]);
            }
        }
        return count;
    }
}
