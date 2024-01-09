package day.y24m01;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Author: CuiChengLong
 * @Date: 2024/1/9 8:56
 * @Description
 */
public class D_01_09_字符串中的额外字符 {

    public static int minExtraChar(String s, String[] dictionary) {
        //Define DP[i] as the min extra character if breaking up s[0:i] optimally.
        int[] dp = new int[s.length() + 1];
        HashSet<String> set = new HashSet<>(Arrays.asList(dictionary));
        for (int i = 1; i <= s.length(); i++) {
            dp[i] = dp[i-1] + 1;
            for (int j = 0; j < i; j++) {
                if (set.contains(s.substring(j,i))) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String[] dictionary = new String[]{"leet","code","leetcode"};
        minExtraChar("leetscode",dictionary);
        minExtraChar2("leetscode",dictionary);
    }

    public static int minExtraChar2(String s, String[] dictionary) {
        //Define DP[i] as the min extra character if breaking up s[0:i] optimally.
        int[] dp = new int[s.length() + 1];
        HashSet<String> set = new HashSet<>(Arrays.asList(dictionary));
        for (int i = 1; i <= s.length(); i++) {
            int x = dp[i-1] + 1;
            for (int j = 0; j < i; j++) {
                if (set.contains(s.substring(j,i))) {
                    dp[i] = Math.min(x, dp[j]);
                } else {
                    dp[i] = x;
                }
            }
        }
        return dp[s.length()];
    }

}
