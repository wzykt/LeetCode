package tree;

/**
 * 222. 完全二叉树的节点个数
 *
 * @date 2021/9/23
 * @description 二分中的题目，但是不知道哪里用到了二分
 * <p>
 * 查看答案：自己的代码没有使用到完全二叉树的性质，而是常规的二叉树遍历。官方答案二分结合完全二叉树性质解决问题
 */
public class _222 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return process(root) + 1;
    }

    //统计二叉树节点个数，递归方式
    public static int process(TreeNode node) {
        int sum = 0;
        if (node.left != null) {
            sum += process(node.left) + 1;
        }
        if (node.right != null) {
            sum += process(node.right) + 1;
        }
        return sum;
    }
    //简化的
    //private int countLevel(TreeNode root){
    //        if(root == null){
    //            return 0;
    //        }
    //        return Math.max(countLevel(root.left),countLevel(root.right)) + 1;
    //}


    /*
    官方答案

    完全想不到
     public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = 0;
        TreeNode node = root;
        while (node.left != null) {
            level++;
            node = node.left;
        }
        int low = 1 << level, high = (1 << (level + 1)) - 1;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (exists(root, level, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public boolean exists(TreeNode root, int level, int k) {
        int bits = 1 << (level - 1);
        TreeNode node = root;
        while (node != null && bits > 0) {
            if ((bits & k) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            bits >>= 1;
        }
        return node != null;
    }

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/count-complete-tree-nodes/solution/wan-quan-er-cha-shu-de-jie-dian-ge-shu-by-leetco-2/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
