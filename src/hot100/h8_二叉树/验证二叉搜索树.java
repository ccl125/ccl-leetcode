package hot100.h8_二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author CuiChengLong
 * @Date 2024/1/17 21:51
 * @Description
 */

public class 验证二叉搜索树 {

    List<Integer> temp = new ArrayList<>();

    public void inorderTraversal(TreeNode root) {
        if(root == null) return;
        inorderTraversal(root.left);
        temp.add(root.val);
        inorderTraversal(root.right);
    }

    public boolean isValidBST(TreeNode root) {
        inorderTraversal(root);
        for(int i = 0; i < temp.size() - 1; i++) {
            // System.out.println("i= " + temp.get(i));
            if (temp.get(i + 1) <= temp.get(i)) {
                return false;
            }
        }
        return true;
    }



}
