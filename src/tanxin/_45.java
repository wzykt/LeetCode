package tanxin;


/**
 * 45. 跳跃游戏 II
 *
 * @date 2021/10/4 2021/10/4完成 2022-1-13再次完成
 * @description 自己的思路超时了，每一个都遍历，太复杂了
 * <p>
 * 答案：使用贪心，我们每次在可跳范围内选择可以使得跳的更远的位置。
 */
public class _45 {
//2021/10/4
//    public static int jump(int[] nums) {
//        int len = nums.length;
//        ArrayList<Integer> list = new ArrayList<>();
//        process(nums, len, 0, 0, list);
//        System.out.println(list.toString());
//
//        Collections.sort(list);
//        System.out.println(list.toString());
//        return list.get(0);
//    }
//
//    public static void process(int[] nums, int len, int index, int step, ArrayList<Integer> list) {
//        if (index >= len-1) {
//            list.add(step);
//            return;
//        }
//        if (nums[index] == 0) {
//            return;
//        }
//
//        for (int i = 1; i <= nums[index]; i++) {//System.out.println("index " + index + ": step:" + step);
//            process(nums, len, index + i, step + 1, list);
//
//        }
//    }

    //贪心写法1
    /*public static int jump(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            //找能跳的最远的
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) { //遇到边界，就更新边界，并且步数加一
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }*/

    //贪心写法2
    //2022-1-13
    /**
     * 贪心的思路，局部最优：当前可移动距离尽可能多走，如果还没到终点，步数再加一。整体最优：一步尽可能多走，从而达到最小步数。
     * <p>
     * 思路虽然是这样，但在写代码的时候还不能真的就能跳多远跳远，那样就不知道下一步最远能跳到哪里了。
     * <p>
     * 所以真正解题的时候，要从覆盖范围出发，不管怎么跳，覆盖范围内一定是可以跳到的，以最小的步数增加覆盖范围，覆盖范围一旦覆盖了终点，得到的就是最小步数！
     * <p>
     * 这里需要统计两个覆盖范围，当前这一步的最大覆盖和下一步最大覆盖。
     * <p>
     * 如果移动下标达到了当前这一步的最大覆盖最远距离了，还没有到终点的话，那么就必须再走一步来增加覆盖范围，直到覆盖范围覆盖了终点。
     */
    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }

        int steps = 0;
        int maxDistance = 0;
        int temDistance = 0;

        for (int i = 0; i < nums.length; i++) {
            maxDistance = Math.max(maxDistance, i + nums[i]);
            if (maxDistance >= nums.length - 1) {
                steps++;
                break;
            }

            if (temDistance == i) {
                temDistance = maxDistance;
                steps++;
            }
        }
        return steps;
    }

}
