package hot100.h8_二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: CuiChengLong
 * @Date: 2024/1/18 19:25
 * @Description
 */
public class 二叉树展开为链表 {

    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        preorderTraversal(root, list);
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i - 1), curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    public void preorderTraversal(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }
    }

}
