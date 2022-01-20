package dp;

/**
 * @date 2022-1-19 2022-1-20完成
 * @description 96. 不同的二叉搜索树
 * <p>
 * 递推公式：状态转移方程dp[i] += dp[j] * dp[i - j - 1];
 * <p>
 * 从定义上来讲，空节点也是一棵二叉树，也是一棵二叉搜索树，这是可以说得通的。
 * 从递归公式上来讲，dp[以j为头结点左子树节点数量] * dp[以j为头结点右子树节点数量] 中以j为头结点左子树节点数量为0，
 * 也需要dp[以j为头结点左子树节点数量] = 1， 否则乘法的结果就都变成0了。
 * 所以初始化dp[0] = 1
 */
public class _96 {
    public int numTrees(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}
