package hot100.h17_动态规划;

/**
 * @Author CuiChengLong
 * @Date 2024/5/8 20:00
 * @Description
 */
public class t_最长重复子数组 {

    public int findLength(int[] nums1, int[] nums2) {
        //画出矩阵，dp[i][j] 代表每个位置最长的子数组
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int res = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    //当前一个数组相同的时候，因为题目要求的子数组是连续的，所以递推公式应该是i-1和j-1推导出来的
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    //在这个过程中去更新res每个位置都可能是最大值，无后效性
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }

}
