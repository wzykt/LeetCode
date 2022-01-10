package tree;

import util.TreeNode;

/**
 * @date 2022-1-10  2022-1-10完成
 * @description 108. 将有序数组转换为二叉搜索树
 *
 * 利用二分特性
 */
public class _108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;

        TreeNode root = build(nums, 0, len - 1);
        return root;
    }

    public TreeNode build(int[] nums, int left, int right) {
        TreeNode node = null;
        if (left <= right) {
            int t = (left + right + 1) / 2;
            node = new TreeNode(nums[t]);
            node.left = build(nums, left, t - 1);
            node.right = build(nums, t + 1, right);
        }
        return node;
    }
}