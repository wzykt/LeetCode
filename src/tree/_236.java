package tree;

import util.TreeNode;



/**
 * @date 2022-1-9 2022-1-9完成
 * @description 236. 二叉树的最近公共祖先
 *
 * 参考答案完成
 *
 * 关于找父节点，可以用后序遍历，左右中
 */
public class _236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return backTracking(root, p, q);
    }

    public TreeNode backTracking(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p) {
            return root;
        }
        if (root == q) {
            return root;
        }
        TreeNode left = backTracking(root.left, p, q);
        TreeNode right = backTracking(root.right, p, q);

        if (left == null && right != null) {
            return right;
        } else if (right == null && left != null) {
            return left;
        } else if(right == null && left == null){
            return null;
        }else {
            return root;
        }
    }
       /* List<TreeNode> rootTree = new ArrayList<>();
        List<TreeNode> pTree = new ArrayList<>();
        List<TreeNode> qTree = new ArrayList<>();

        process(root, rootTree);
        process(p, pTree);
        process(q, qTree);

        if (pTree.contains(q)) {
            return p;
        }
        if (qTree.contains(p)) {
            return q;
        }

        for (int i = 0; i < rootTree.size(); i++) {
            if (rootTree.get(i).equals(q) || rootTree.get(i).equals(p)) {
                return rootTree.get(i - 1);
            }
        }
        return null;
    }

    public void process(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        //逻辑
        list.add(root);
        process(root.left, list);
        process(root.right, list);
    }*/
}
