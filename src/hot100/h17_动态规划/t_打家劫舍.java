package hot100.h17_动态规划;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author CuiChengLong
 * @Date 2024/5/8 20:48
 * @Description
 */
public class t_打家劫舍 {

    public int rob(int[] nums) {
        //特殊情况判断
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        //代表当前夜晚能偷到的最高金额
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        //第二个晚上最高的金额为前两个夜晚的最大值
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            //当前夜晚能偷到的最大价值可能是这个晚上不偷，前一个晚上偷的钱
            //也可能是这个晚上偷钱也就是获取到了nums[i]的金额，加上除去前面夜晚的前前个夜晚的最高金额，因为不能连续偷
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        // System.out.println(Arrays.toString(dp));
        //最终的夜晚是最大的价值，有后效性
        return dp[nums.length - 1];
    }

    //输出路径
    //dp[i][0]代表不偷第i号房屋所能获得最大金额
    //dp[i][1]代表偷第i号房屋所能获得最大金额
    public List<Integer> rob2(int[] nums) {
        if (nums.length == 1) {
            return new ArrayList<>(Collections.singletonList(nums[0])) ;
        }
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        dp[1][0] = nums[0];
        dp[1][1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][1] = Math.max(dp[i - 2][1] + nums[i], dp[i - 2][0] + nums[i]);
        }
        int target = Math.max(dp[nums.length - 1][0],dp[nums.length - 1][1]);
        List<Integer> track = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (dp[i][1] == target) {
                target = target - nums[i];
                track.add(nums[i]);
            }
        }
        Collections.reverse(track);
        return track;
    }


}
