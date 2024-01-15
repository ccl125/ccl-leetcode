package hot100.h8_二叉树;

/**
 * @Author CuiChengLong
 * @Date 2024/1/15 23:38
 * @Description
 */

public class 二叉树的最大深度 {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

}
