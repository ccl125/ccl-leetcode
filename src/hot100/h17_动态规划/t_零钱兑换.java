package hot100.h17_动态规划;

/**
 * @Author CuiChengLong
 * @Date 2024/5/8 21:05
 * @Description
 */
public class t_零钱兑换 {

    public int coinChange(int[] coins, int amount) {
        // 表示每个i金额对应的最少硬币数
        int[] dp = new int[amount + 1];
        // 1、遍历每个金额数量，从1到题目给定的amount
        for (int i = 1; i <= amount; i++) {
            // 后面的状态方程是根据min来更新，如果dp初始化0的话min最少是 (1 + xxx),永远也没办法更新，所以
            // 把每个金额对应的最少硬币数更新为amount + 1 ，这个值是永远也不可能成立的，因为硬币数不可能比总金额大。
            dp[i] = amount + 1;
            // 2、遍历每个硬币，开始更新状态方程。
            for (int c : coins) {
                // 3、如果 i - c >= 0, 说明当前对应的遍历情况不存在，比如金额1的时候用面额为5的来更新。
                if (i - c >= 0) {
                    // 每个金额对应的最少硬币数，就是这个dp[i] 自身或者自身减去金额对应的硬币的最少数量加上本身的1，
                    // 上面的dp[i] = amount + 1 不会影响结果，应该默认dp[0] = 0, 也就是遇到对应硬币面额的时候，会取后面的最小值也就是1
                    dp[i] = Math.min(dp[i], 1 + dp[i - c]);
                }
            }
        }
        // 如果最终结果 >= amount + 1, 就是非预期结果，可能是示例二。
        return dp[amount] >= amount + 1 ? -1 : dp[amount];
    }

    //零钱兑换2
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int c : coins) {
            for (int i = 1; i <= amount; i++) {
                if (i - c >= 0)
                    dp[i] = dp[i] + dp[i - c];
            }
        }
        return dp[amount];
    }

}

