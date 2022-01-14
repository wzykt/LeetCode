package tanxin;

import java.util.Arrays;

/**
 * @date 2022-1-14 2022-1-14完成
 * @description 135. 分发糖果
 *
 * 结论：从前向后遍历一遍，左孩子小于右孩子，右孩子糖果就比左孩子糖果数量多一个
 * 再从后向前遍历，左孩子大于右孩子，选择右孩子加1和左孩子中糖果数量较多的一个赋值给左孩子
 *
 * 可以参考406，两者都是分情况讨论，不要两个维度一起考虑
 */
public class _135 {
    public int candy(int[] ratings) {
        int[] res = new int[ratings.length];
        //不要忘记初始化
        res[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i - 1] < ratings[i]) {
                res[i] = res[i - 1] + 1;
            }else {
                res[i] = 1;
            }
        }

        //从后向前判断，左孩子大于右孩子，就有两个选择了，一个是从右边这个加1得到的糖果数量，一个是比较右孩子大于左孩子得到的糖果数量，从后向前遍历是为了利用上res数组
        for (int i = ratings.length - 2; i >= 0; i--) {
            //res[i + 1] + 1 和 res[i] 最大的糖果数量，保证第i个小孩的糖果数量即大于左边的也大于右边的。
            if (ratings[i] > ratings[i + 1]) {
                res[i] = Math.max(res[i], res[i + 1] + 1);
            }
        }

        int count = 0;
        for (int i = 0; i < res.length; i++) {
            count += res[i];
        }
        return count;
    }
}
