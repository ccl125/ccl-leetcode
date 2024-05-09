package hot100.h17_动态规划;

import java.util.Arrays;

/**
 * @Author CuiChengLong
 * @Date 2024/5/8 19:04
 * @Description
 */
public class t_最长递增子序列 {

    public int lengthOfLIS(int[] nums) {
        //dp代表每个元素位置最长的递增子序列
        int[] dp = new int[nums.length];
        //每个位置自身就是1
        Arrays.fill(dp, 1);
        //最终结果也是1是最小值
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            //去前面找，如果有小于当前的元素的话，更新dp递推方程
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    //当前位置的最长子序列要么是前面小于自身的+1要么是自身，两者取最大
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    //遍历的过程中去更新答案
                    res = Math.max(res, dp[i]);
                }
            }
        }
        return res;
    }

}
