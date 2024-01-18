package hot100.h8_二叉树;

/**
 * @Author CuiChengLong
 * @Date 2024/1/17 23:15
 * @Description
 */

public class 二叉搜索树中第K小的元素 {

    //这道题错了很多次
    //注意的点有：全局变量在方法中，如果判断++会导致结果改变。所以判断的这个变量不能当成最终的结果返回，要新创建一个变量作为返回结果
    int temp = 0, res = 0;
    public int kthSmallest(TreeNode root, int k) {
        inorderTraversal(root, k);
        return res;
    }

    public void inorderTraversal(TreeNode root, int k) {
        if (root == null) return;
        inorderTraversal(root.left, k);
        if (++temp == k) {
            res = root.val;
            return;
        }
        inorderTraversal(root.right, k);
    }


}
