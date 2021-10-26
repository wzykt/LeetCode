package demo;



/**
 * 45. 跳跃游戏 II
 *
 * @date 2021/10/4
 * @description 自己的思路超时了，每一个都遍历，太复杂了
 * <p>
 * 答案：使用贪心，我们每次在可跳范围内选择可以使得跳的更远的位置。
 */
public class _45 {

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
    public static int jump(int[] nums) {
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
    }


    public static void main(String[] args) {
        int[] nums = {2, 3, 0, 1, 4};
        System.out.println(jump(nums));
    }
}
