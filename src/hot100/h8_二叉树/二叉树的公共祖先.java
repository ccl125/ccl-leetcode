package hot100.h8_二叉树;

/**
 * @Author: CuiChengLong
 * @Date: 2024/1/19 11:21
 * @Description
 *
 * 算法
 * (递归) O(n)O(n)O(n)
 *
 * 当我们用递归去做这个题时不要被题目误导，应该要明确一点
 * 这个函数的功能有三个：给定两个节点 ppp 和 qqq
 *
 * 如果 ppp 和 qqq 都存在，则返回它们的公共祖先；
 * 如果只存在一个，则返回存在的一个；
 * 如果 ppp 和 qqq 都不存在，则返回 NULL
 * 本题说给定的两个节点都存在，那自然还是能用上面的函数来解决
 *
 * 具体思路：
 * （1） 如果当前结点 rootrootroot 等于 NULL，则直接返回 NULL
 * （2） 如果 rootrootroot 等于 ppp 或者 qqq ，那这棵树一定返回 ppp 或者 qqq
 * （3） 然后递归左右子树，因为是递归，使用函数后可认为左右子树已经算出结果，用 leftleftleft 和 rightrightright 表示
 * （4） 此时若leftleftleft为空，那最终结果只要看 rightrightright；若 rightrightright 为空，那最终结果只要看 leftleftleft
 * （5） 如果 leftleftleft 和 rightrightright 都非空，因为只给了 ppp 和 qqq 两个结点，都非空，说明一边一个，因此 rootrootroot 是他们的最近公共祖先
 * （6） 如果 leftleftleft 和 rightrightright 都为空，则返回空（其实已经包含在前面的情况中了）

 *
 */
public class 二叉树的公共祖先 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p ,q);
        if (left == null) return  right;
        if (right == null) return left;
        return root;
    }

}
