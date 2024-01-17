package hot100.h8_二叉树;

/**
 * @Author CuiChengLong
 * @Date 2024/1/17 22:05
 * @Description
 */

public class 验证二叉搜索树_2 {

    // 下面的思路很巧妙，可以看出来就是一个中序遍历，但是在中序遍历的时候，通过Pre这个变量就能够判断是否是顺序的BST
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 先一直走到最左，也就是最小的一个元素
        // 访问左子树
        if (!isValidBST(root.left)) {
            return false;
        }
        // 对最小的元素判断，同时更新pre，然后向上归
        // 判断当前节点是否符合BST 中序遍历，所以每次都应该满足大于 pre 才是BST
        if (root.val <= pre) {
            return false;
        }
        // 更新pre
        pre = root.val;
        // 访问右子树。
        return isValidBST(root.right);
    }

}
