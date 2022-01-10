package tree;

import util.TreeNode;

import java.util.List;

/**
 * @date 2022-1-10 2022-1-10完成
 * @description 538. 把二叉搜索树转换为累加树
 *
 * 使用暴力方式完成
 *
 * 参考答案：反中序遍历
 */
public class _538 {
    /*List<Integer> list;

    public TreeNode convertBST(TreeNode root) {
        search(root);
        process(root);
        return root;
    }

    public void search(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.left);
        search(node.left);
        list.add(node.val);
        search(node.right);
    }

    public int getIndex(List<Integer> list, int num) {
        return list.indexOf(num);
    }

    public int sum(int index, List<Integer> list) {
        int sum = 0;
        for (int i = index; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }


    public void process(TreeNode node) {
        if (node == null) {
            return;
        }
        int val = node.val;
        int index = getIndex(list, val);
        node.val = sum(index, list);
        process(node.left);
        process(node.right);
    }*/
    int sum;
    public TreeNode convertBST(TreeNode root) {
        sum = 0;
        convertBST1(root);
        return root;
    }

    // 按右中左顺序遍历，累加即可
    public void convertBST1(TreeNode root) {
        if (root == null) {
            return;
        }
        convertBST1(root.right);
        sum += root.val;
        root.val = sum;
        convertBST1(root.left);
    }
}
