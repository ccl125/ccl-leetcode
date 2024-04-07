package hot100.h17_动态规划;

import java.util.Arrays;

/**
 * @Author CuiChengLong
 * @Date 2024/4/4 10:10
 * @Description
 */

public class H_零钱兑换 {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i < coins.length; i++) dp[i] = Integer.MAX_VALUE;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0)
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[amount];
    }

}
