package demo;

public class _154 {
    public static int findMin(int[] nums) {
        int mark = nums[0];

        int left = -1,right = nums.length;
        while(left + 1 != right){
            int m = (left + right) /2;
            if(mark < nums[m]){
                left = m;
            }else {
                right = m;
            }
        }
        if(nums.length == right){
            return nums[0];
        }
        return nums[right];
    }

    public static void main(String[] args) {
        int nums[] = {10,1,10,10,10};
        System.out.println(findMin(nums));

    }
}
