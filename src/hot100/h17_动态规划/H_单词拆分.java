package hot100.h17_动态规划;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author CuiChengLong
 * @Date 2024/4/4 17:49
 * @Description
 */

public class H_单词拆分 {

    public boolean wordBreak(String s, List<String> wordDict) {
        // 动态规划
        boolean[] dp = new boolean[s.length() + 1]; // dp数组用于存储子问题的解
        dp[0] = true; // 空字符串可以被拆分，所以dp[0]为true

        // 遍历字符串s的所有字符
        for (int i = 1; i <= s.length(); i++) {
            // 遍历字典中的每一个单词
            for (String word : wordDict) {
                if (i < word.length()) continue; // 如果当前字符串长度小于单词长度，跳过当前循环

                // 如果字符串s从0到i的子串以当前单词结尾，并且从0到i减去单词长度的子串可以被拆分
                if (s.substring(0, i).endsWith(word)) {
                    if (dp[s.substring(0, i - word.length()).length()]) {
                        dp[i] = true; // 更新dp[i]为true
                    }
                }
            }
        }

        return dp[s.length()]; // 返回字符串s是否可以被拆分
    }

    public static void main(String[] args) {
        H_单词拆分 test = new H_单词拆分();
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        test.wordBreak("leetcode", wordDict);
    }

}
