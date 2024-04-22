package day.y24m04;

/**
 * @Author CuiChengLong
 * @Date 2024/4/22 1:05
 * @Description
 * 组合总和 Ⅳ
 * https://leetcode.cn/problems/combination-sum-iv/description/?envType=daily-question&envId=Invalid%20Date
 *
 */

public class D_04_22_组合总和 {

    //DFS做的超时了
    int res = 0;
    public int combinationSum4(int[] nums, int target) {
        dfs(nums, target, 0);
        return res;
    }

    public void dfs(int[] nums, int target, int cur) {
        if (cur > target) return;
        if (cur == target) {
            res++;
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            cur += nums[i];
            dfs(nums, target, cur);
            cur -= nums[i];
        }
    }

    //换种思路，爬楼梯，每次爬的步数为nums[i].楼梯阶数是target。一共多少种走法
    //换种思路里面清晰了有没有，因为爬楼梯是dp，就是阶数target，那我能不能先求出来target-1是多少个组合呢，dp[target] = dp[target - 1] +
    public int combinationSum4_V2(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                //首先每个数减去遍历到数组中的元素必须大于才能去更新结果，比如算5这个阶梯，此时遍历数组nums[x]是10.那我肯定是不能去更新结果的
                //想法，如歌nums[x] 是 2 ，那么5这个阶梯可以说找到了一种方式，就是dp[5] = dp[3]的结果加上我自己也就是dp[5],因为我找到了数字2，必然可以这样添加到结果集
                if (i - nums[j] >= 0) {
                    dp[i] = dp[i] + dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }


}
