package hot100.h8_二叉树;

import java.util.LinkedList;

/**
 * @Author: CuiChengLong
 * @Date: 2024/1/18 19:25
 * @Description
 */
public class 二叉树展开为链表 {

    public static void flatten(TreeNode root) {
        dfs(root);
        // System.out.println(temp);
        temp.pollLast();
        help(root);
    }

    public static void help(TreeNode root) {
        if (root == null || temp.peekLast() == null) return;
        root.left = null;
        root.right = new TreeNode(temp.pollLast());
        // System.out.println(temp.pollFirst());
        help(root.right);
    }


    static LinkedList<Integer> temp = new LinkedList<>();
    public static void dfs(TreeNode root) {
        if (root == null) return;
        temp.addFirst(root.val);
        dfs(root.left);
        dfs(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(5);
        root.left = left;
        root.right = right;
        left .left = new TreeNode(3);
        left .right = new TreeNode(4);
        right.left = new TreeNode(6);
        flatten(root);
    }

}
