package tree;

import util.TreeNode;

/**
 * @date 2022-1-4 2022-1-4完成
 * @description 654. 最大二叉树
 *
 * 类似与105和106，可以套用模板
 */
public class _654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length);
    }

    public TreeNode build(int[] nums, int leftBound, int rightBound) {
        if (leftBound >= rightBound) {
            return null;
        }

        int maxIndex = leftBound;
        int max = nums[leftBound];
        for (int i = leftBound; i < rightBound; i++) {
            if (nums[i] > max) {
                maxIndex = i;
                max = nums[i];
            }
        }
        TreeNode node = new TreeNode(nums[maxIndex]);

        node.left = build(nums, leftBound, maxIndex - 1);
        node.right = build(nums, maxIndex + 1, rightBound);
        return node;
    }
}
