package tree;

import sun.reflect.generics.tree.Tree;
import util.TreeNode;

import java.util.*;

/**
 * @date 2022-1-3 2022-1-3完成
 * @description 513. 找树左下角的值
 *
 * 利用层级遍历实现
 */
public class _513 {
    public int findBottomLeftValue(TreeNode root) {
        Map<Integer, TreeNode> map = new TreeMap<>();
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        int level = 1;
        deque.add(root);
        while (!deque.isEmpty()) {
            int len = deque.size();
            while (len > 0) {
                TreeNode pop = deque.pop();
                if (!map.containsKey(level)) {
                    map.put(level, pop);
                }
                if (pop.left != null) {
                    deque.offer(pop.left);
                }
                if (pop.right != null) {
                    deque.offer(pop.right);
                }
                len--;
            }
            level++;
        }
        return map.get(level-1).val;
    }
}
