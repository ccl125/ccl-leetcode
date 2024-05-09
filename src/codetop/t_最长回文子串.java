package codetop;

/**
 * @Author CuiChengLong
 * @Date 2024/5/7 18:06
 * @Description
 */

public class t_最长回文子串 {

    public String longestPalindrome(String s) {
        //特殊用例判断
        int len=s.length();
        if(len<2) return s;
        int maxLen=1;
        int begin=0;

        //dp[i][j]表示s[i,j]是否是回文串
        boolean[][] dp=new boolean[len][len];
        char[] charArray=s.toCharArray();
        for (int i = 0; i < len; i++) {
            dp[i][i]=true;
        }
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if(charArray[i]!=charArray[j]){
                    dp[i][j]=false;
                }else {
                    if(j-i<3){
                        dp[i][j]=true;
                    }else {
                        dp[i][j]=dp[i+1][j-1];
                    }
                }
                if(dp[i][j]&&j-i+1>maxLen){
                    maxLen=j-i+1;
                    begin=i;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }

}
