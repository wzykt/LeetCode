package demo;

/**
 * 98. 验证二叉搜索树
 *
 * @date 2021/9/25
 * @description 注意记录左右子树的最大值和最小值
 */


public class _98 {
    //    public boolean isValidBST(TreeNode root) {
//        return process(root).isTrue;
//    }
//
//    public static class Info {
//        Boolean isTrue;
//        Integer Max;
//        Integer Min;
//
//        public Info(boolean isTrue, Integer max, Integer min) {
//            this.isTrue = isTrue;
//            this.Max = max;
//            this.Min = min;
//        }
//
//        public Info(boolean isTrue) {
//            this.isTrue = isTrue;
//            this.Max = null;
//            this.Min = null;
//        }
//
//    }
//
//    public Info process(TreeNode node) {
//        if (node == null) {
//            return new Info(true);
//        }
//
//        Info leftInfo = process(node.left); System.out.println("leftInfo.leftMax "+leftInfo.Max);
//        Info rightInfo = process(node.right);System.out.println("rightInfo.rightMin "+rightInfo.Min);
//        boolean m = true;
//        if (leftInfo.Max != null) {
//            if (leftInfo.Max >= node.val){
//                m = false;
//            }
//        }
//        if (rightInfo.Min != null) {
//            if (rightInfo.Min <= node.val){
//                m = false;
//            }
//        }
//
//        //这里卡了我很久左子树记录最小，右子树记录最大
//        int min = leftInfo.Max == null ? node.val  : Math.min(node.val, leftInfo.Min);
//        int max = rightInfo.Min == null ? node.val : Math.max(node.val, rightInfo.Max);
//        return new Info(m && leftInfo.isTrue && rightInfo.isTrue, max, min);
//    }
//
//    public static void main(String[] args) {
//        Integer i = null;
//        boolean b = i != null;
//        System.out.println(b);
//    }
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

    //更简单的方法
    //利用中序遍历来实现
    //记住一个结论，对于二叉搜索树，中序遍历的结果就行排好序的，利用这个结论，就判断当前节点是否大于上一个节点即可
    long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 访问左子树
        if (!isValidBST(root.left)) {
            return false;
        }
        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        // 访问右子树
        return isValidBST(root.right);
    }
}
