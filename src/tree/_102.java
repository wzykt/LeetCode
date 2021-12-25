package tree;

import java.util.*;

/**
 * 102. 二叉树的层序遍历
 *
 * @date 2021/9/9
 * @description 使用队列, 并且它和普通广度优先搜索的区别在于，普通广度优先搜索每次只取一个元素拓展，而这里每次取多个元素
 * 我们可以用一种巧妙的方法修改广度优先搜索：
 *  首先根元素入队
 *  当队列不为空的时候
 *      求当前队列的长度 s
 *      依次从队列中取个元素进行拓展，然后进入下一次迭代
 */
public class _102 {
    static class TreeNode {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            //使用循环，将每一层的TreeNode都加入到队列中去
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }

        return ret;
    }
}
