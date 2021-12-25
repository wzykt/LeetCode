package hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @date 2021-12-18
 * @description 15. 三数之和
 */
public class _15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return result;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (right > left) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    //去重
                    while (right > left && nums[right] == nums[right - 1]) right--;
                    while (right > left && nums[left] == nums[left + 1]) left++;

                    right--;
                    left++;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums = {-2, 0, 1, 1, 2};
        //-1,0,1,2,-1,-4
        //[-2,0,1,1,2]
       // System.out.println(threeSum(nums));
    }
}
