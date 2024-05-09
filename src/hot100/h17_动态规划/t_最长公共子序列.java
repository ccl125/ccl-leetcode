package hot100.h17_动态规划;

/**
 * @Author CuiChengLong
 * @Date 2024/5/8 19:09
 * @Description
 *
 * https://programmercarl.com/1143.%E6%9C%80%E9%95%BF%E5%85%AC%E5%85%B1%E5%AD%90%E5%BA%8F%E5%88%97.html#%E6%80%9D%E8%B7%AF
 *
 */
public class t_最长公共子序列 {

    public int longestCommonSubsequence(String text1, String text2) {
        //画出矩阵，dp的含义是长度为[0,i-1]的text1和text2的最长子序列是dp[i][j]
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                //如果字符串相等了，那么最长的公共序列为前面的最长的+1
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    //如果字符串不相等，那么最长的公共序列为要么text1减去这个不相等的和j长度的text2去比的值
                    //要么是text2减去这个不相等的，去和i比，也就是dp[i][j-1];取最大的
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

}
