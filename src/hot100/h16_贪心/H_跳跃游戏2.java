package hot100.h16_贪心;

/**
 * @Author CuiChengLong
 * @Date 2024/4/3 19:24
 * @Description 和跳跃游戏1一样，都用dp解决
 */

public class H_跳跃游戏2 {

    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        //每个i代表每个位置的最小步数
        //0为0，下面dp[i] + 1正好更新每个位置，所以除0其他都赋值为最大值
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        //枚举每个数组
        for (int i = 0; i < nums.length; i++) {
            //根据当前数组的最大步数枚举每个位置的最小值，最小值等于当前的i + j，或者是直接由枚举的i跳过去，也就是+1
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j < dp.length) {
                    dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
                }
            }
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        H_跳跃游戏2 test = new H_跳跃游戏2();
        test.jump(new int[]{2, 3, 1, 1, 4});
    }

}
