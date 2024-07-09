package hot100.h8_二叉树;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author CuiChengLong
 * @Date 2024/1/18 21:00
 * @Description
 */

public class 从前序与中序遍历序列构造二叉树 {

    int[] preorder;
    HashMap<Integer, Integer> dic = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for(int i = 0; i < inorder.length; i++)
            dic.put(inorder[i], i);
        return recur(0, 0, inorder.length - 1);
    }
    TreeNode recur(int root, int left, int right) {
        // 递归终止
        if (left > right) return null;
        // 建立根节点
        TreeNode node = new TreeNode(preorder[root]);
        // 划分根节点、左子树、右子树
        int i = dic.get(preorder[root]);
        // 开启左子树递归
        node.left = recur(root + 1, left, i - 1);
        // 开启右子树递归
        node.right = recur(root + i - left + 1, i + 1, right);
        // 回溯返回根节点
        return node;
    }

}
