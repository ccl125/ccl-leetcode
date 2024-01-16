package hot100.h8_二叉树;

/**
 * @Author: CuiChengLong
 * @Date: 2024/1/16 11:37
 * @Description
 */
public class 对称二叉树 {


    boolean flag = true;

    public boolean isSymmetric(TreeNode root) {
        return help(root.left, root.right);
    }

    public boolean help(TreeNode left, TreeNode right) {
        if (right == null && left == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return right.val == left.val && help(left.left, right.right) && help(left.right, right.left);

    }


}
