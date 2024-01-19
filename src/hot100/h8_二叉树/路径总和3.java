package hot100.h8_二叉树;

/**
 * @Author: CuiChengLong
 * @Date: 2024/1/19 9:41
 * @Description
 */
public class 路径总和3 {

    int ans = 0;
    long target;
    public int pathSum(TreeNode root, int targetSum) {
        this.target = targetSum;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs2(root, root.val);
        dfs(root.left);
        dfs(root.right);
    }

    //long 还卡了下数据范围
    public void dfs2(TreeNode root, long sum) {
        if (target == sum) ans++;
        if (root.left != null) dfs2(root.left, sum + root.left.val);
        if (root.right != null) dfs2(root.right, sum + root.right.val);

    }


}
