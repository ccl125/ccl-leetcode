package hot100.h8_二叉树;

/**
 * @Author CuiChengLong
 * @Date 2024/1/19 23:41
 * @Description
 */

public class 二叉树的最大路径 {

    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfsNode(root);
        return res;
    }

    // res在更新的时候，也就是最终结果的时候是要去进行left+right+node.val这种情况比较大小的
    // 但是return的时候，递归的方法就是获取一个节点最大的一条路径的值，所以这里不需要left+right，而是直接判断Math.max(left, right)
    // 在加上node.val
    public int dfsNode(TreeNode node) {
        if (node == null) return 0;
        // 获取左边最大值
        int left = dfsNode(node.left);
        // 获取右边最大值
        int right = dfsNode(node.right);
        // 每个节点的条件要么是 左右相加再加本身
        res = Math.max(res, left + right + node.val);
        // 要么是左边最大加本身
        res = Math.max(res, left + node.val);
        // 要么是右边最大加本身
        res = Math.max(res, right + node.val);
        // 要么是本身
        res = Math.max(res, node.val);
        // 最终结果就是左右最大加上自身，但是如果左右最大都比自身小，就直接返回自身
        return Math.max(0, Math.max(left, right)) + node.val;
    }

}
