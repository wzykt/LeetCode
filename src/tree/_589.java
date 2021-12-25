package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 2021-12-25 2021-12-25完成
 * @description 589. N 叉树的前序遍历
 *
 * 这里就是用了简单的递归，没有使用迭代的方式去做
 */
public class _589 {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        res.add(root.val);
        process(root, res);
        return res;
    }

    public void process(Node node, List<Integer> res) {
        if (node == null) {
            res.add(null);
        }
        for (int i = 0; i < node.children.size(); i++) {
            Node node1 = node.children.get(i);
            res.add(node1.val);
            process(node1, res);
        }
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}