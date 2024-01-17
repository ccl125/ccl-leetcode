package hot100.h8_二叉树;

/**
 * @Author: CuiChengLong
 * @Date: 2024/1/17 18:01
 * @Description 反着的二分
 */
public class 将有序数组转换为二叉搜索树 {

    public static TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    public static TreeNode dfs(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = (right + left) / 2;
        System.out.println("left is " + left + ", right is " + right + ", mid is " + mid);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, left, mid - 1);
        root.right = dfs(nums, mid + 1, right);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-10,-3,0,5,9};
        sortedArrayToBST(nums);
    }

}
