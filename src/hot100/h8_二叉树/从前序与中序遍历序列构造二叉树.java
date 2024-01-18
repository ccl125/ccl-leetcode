package hot100.h8_二叉树;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author CuiChengLong
 * @Date 2024/1/18 21:00
 * @Description
 */

public class 从前序与中序遍历序列构造二叉树 {

    private Map<Integer, Integer> indexMap;

    public TreeNode build(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) return null;
        int inorder_root = indexMap.get(preorder[preorder_left]);
        TreeNode root = new TreeNode(preorder[preorder_left]);
        int size_left_subtree = inorder_root - inorder_left;
        root.left = build(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        root.right = build(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, n - 1, 0, n - 1);
    }


}
