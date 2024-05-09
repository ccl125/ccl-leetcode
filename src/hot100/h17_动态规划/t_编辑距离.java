package hot100.h17_动态规划;

/**
 * @Author CuiChengLong
 * @Date 2024/5/8 20:31
 * @Description
 */
public class t_编辑距离 {

    public int minDistance(String word1, String word2) {
        // dp[i][j]代表word1中前i个字符变换到word2中前j个字符最短需要操作的次数
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        // word2一个字母也没有，全删
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }
        // word1一个字母都没有，全增
        for (int j = 1; j < dp[0].length; j++) {
            dp[0][j] = dp[0][j - 1] + 1;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                // 如果相等的情况，每次等于前面的，不需要操作
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 如果不相同的话，要进行一次操作
                    // dp[i - 1][j - 1]改，dp[i - 1][j]删，dp[i][j - 1]增，三个操作取最小，然后+1
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        // 最后字符串相同了，对应的就是答案，有后效性
        return dp[dp.length - 1][dp[0].length - 1];
    }

}
