package hot100.h8_二叉树;

import java.util.Stack;

/**
 * @Author: CuiChengLong
 * @Date: 2024/1/16 10:53
 * @Description 3
 */
public class 翻转二叉树 {

    //递归方法一: 交换左右子树，继续递归左子树，递归右子树
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    //递归方法二：和1其实是一样的。变量少了，invertTree2方法就是去反转的，
    //root.left is invertTree2(root.right) 但是当递归右边子树的时候，由于left已经改变，所以上面要先将left存起来
    //root.right is invertTree2(temp).
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = invertTree2(root.right);
        root.right = invertTree2(temp);
        return root;
    }

    //迭代，通过栈，先将节点push进去，然后每次push出来后交换左右子节点，然后子节点继续进栈
    public TreeNode invertTree3(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            TreeNode temp = pop.left;
            pop.left = pop.right;
            pop.right = temp;
            if (pop.left != null) {
                stack.push(pop.left);
            }
            if (pop.right != null) {
                stack.push(pop.right);
            }
        }
        return root;
    }


}
