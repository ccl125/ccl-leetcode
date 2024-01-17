package hot100.h8_二叉树;

/**
 * @Author: CuiChengLong
 * @Date: 2024/1/17 18:01
 * @Description 反着的二分
 */
public class 将有序数组转换为二叉搜索树_2 {

    public static TreeNode sortedArrayToBST(int[] nums) {
        //二分左闭右开
        return dfs(nums, 0, nums.length);
    }

    public static TreeNode dfs(int[] nums, int left, int right) {
        //首先这里是右闭，也就是当left == right的时候，其实已经不符合nums的边界条件了，所以要终止二分，返回null。
        //所以这里是left >= right 的时候返回null。而不是left > right
        if (left >= right) return null;
        int mid = (right + left) / 2;
        System.out.println("left is " + left + ", right is " + right + ", mid is " + mid);
        TreeNode root = new TreeNode(nums[mid]);
        //右闭，所以在下一次查找的时候，直接还是传入mid，这样不会漏掉区间，也符合我们一开始进入二分的边界条件
        // （整个二分过程中保持边界条件不变，符合边界的处理逻辑）
        // 不能一会逻辑变成了左闭右开一会又变成了左闭右闭，那最终结果肯定不对。
        root.left = dfs(nums, left, mid);
        // 因为是左闭，所以下次二分应该传入的是mid + 1，如果是mid的话，就会造成重复查找，要么得不到正确结果，要么程序陷入死循环中。
        root.right = dfs(nums, mid + 1, right);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-10,-3,0,5,9};
        sortedArrayToBST(nums);
    }

}
