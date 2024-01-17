package hot100.h8_二叉树;

/**
 * @Author: CuiChengLong
 * @Date: 2024/1/17 18:01
 * @Description
 *
 *
 *
 */
public class 将有序数组转换为二叉搜索树 {

    public static TreeNode sortedArrayToBST(int[] nums) {
        //二分左闭右闭
        return dfs(nums, 0, nums.length - 1);
    }

    public static TreeNode dfs(int[] nums, int left, int right) {
        //左闭右闭的时候，当left == right的时候，依然符合nums的条件，数组没有越界，进行的逻辑是继续走二分的while逻辑
        //而到了这个题目中，这里的if其实是要终止二分的条件，所以这里的条件其实是left > right 就终止了。而相等的话，还是继续往下走逻辑
        //对比：other.t_704_二分查找
        if (left > right) return null;
        int mid = (right + left) / 2;
        System.out.println("left is " + left + ", right is " + right + ", mid is " + mid);
        TreeNode root = new TreeNode(nums[mid]);
        //因为是右闭，所以下一次查找的区间就是left 和mid-1,不能再包含mid了.
        root.left = dfs(nums, left, mid - 1);
        //同理左闭。下一次就是mid+1开始，因为如果是mid的话，我们是闭区间，mid就重复搜索mid了，会造成栈溢出。
        //对比下左闭右开的思路：将有序数组转换为二叉搜索树_2
        root.right = dfs(nums, mid + 1, right);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-10,-3,0,5,9};
        sortedArrayToBST(nums);
    }

}
