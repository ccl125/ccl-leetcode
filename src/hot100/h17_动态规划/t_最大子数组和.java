package hot100.h17_动态规划;

/**
 * @Author CuiChengLong
 * @Date 2024/5/8 20:01
 * @Description
 */
public class t_最大子数组和 {

    public int maxSubArray(int[] nums) {
        //每个位置最大的连续子数组和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        //结果的可能值不是0，而是一开始的元素
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            //递推公式，每个位置最大子数组和要么等于前面的最大加上本身，或者就是不算前面的直接本身
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            //无后效行，每次遍历更新答案
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
