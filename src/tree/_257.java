package tree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 2021-12-27 2021-12-27完成
 * @description 257. 二叉树的所有路径
 */
public class _257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        String s = "";
        put(root,res,s);
        return res;
    }

    public void put(TreeNode node, List<String> list, String s) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            s = s + node.val ;
            list.add(s);
        }else{
            s = s + node.val + "->" ;
        }
        put(node.left, list, s);
        put(node.right, list, s);
    }
}
