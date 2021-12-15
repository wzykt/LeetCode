package demo;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @date 2021/12/3 2021/12/3完成
 * @description 836. 矩形重叠
 * <p>
 * 我的思路是找相交的情况，其实找不相交的情况也可以，而且不相交的情况更少
 *
 * 逆向想一下
 */
public class _836 {

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if (rec1[0] >= rec2[2] || rec1[3] <= rec2[1]) {
            return false;
        }
        if (rec1[2] <= rec2[0] || rec1[3] <= rec2[1]) {
            return false;
        }
        if (rec1[0] >= rec2[2] || rec1[1] >= rec2[3]) {
            return false;
        }
        if (rec1[2] <= rec2[0] || rec1[1] >= rec2[3]) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
