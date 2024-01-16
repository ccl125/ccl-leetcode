package hot100.h8_二叉树;

/**
 * @Author: CuiChengLong
 * @Date: 2024/1/16 18:55
 * @Description
 */
public class 二叉树的直径 {

    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return max;
        max = Math.max(maxDeep(root.left) + maxDeep(root.right), max);
        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);
        return max;
    }

    // find every node max deep
    public int maxDeep(TreeNode node) {
        if (node == null) return 0;
        return Math.max(maxDeep(node.left), maxDeep(node.right)) + 1;
    }


}
