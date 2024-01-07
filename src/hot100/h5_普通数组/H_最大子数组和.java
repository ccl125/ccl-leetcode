package hot100.h5_普通数组;

/**
 * @Author: CuiChengLong
 * @Date: 2023/12/19 19:26
 * @Description
 */
public class H_最大子数组和 {

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        H_最大子数组和 test = new H_最大子数组和();
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(test.maxSubArray(nums));
    }


}
