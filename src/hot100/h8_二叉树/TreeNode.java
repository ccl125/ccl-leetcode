package hot100.h8_二叉树;

/**
 * @Author CuiChengLong
 * @Date 2024/1/15 23:35
 * @Description
 */

public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) {
        this.val =val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
