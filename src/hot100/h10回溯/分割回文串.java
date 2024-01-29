package hot100.h10回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: CuiChengLong
 * @Date: 2024/1/29 17:04
 * @Description
 */
public class 分割回文串 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        int len = s.length();
        dfs(s, temp, 0, res, len);
        return res;
    }
    //分割字符串. len：分割大小
    public void dfs(String str, List<String> temp, int ans, List<List<String>> res, int len) {
        if (ans == len && checkPalindromeList(temp)) {
            res.add(new ArrayList<>(temp));
        }
        for (int i = 1; i <= str.length(); i++) {
            temp.add(str.substring(0, i));
            ans += i;
            dfs(str.substring(i), temp, ans, res, len);
            temp.remove(temp.size() - 1);
            ans -= i;
        }
    }


    public boolean checkPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left <= right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean checkPalindromeList(List<String> strList) {
        for (String str : strList) {
            if (!checkPalindrome(str)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        分割回文串 test = new 分割回文串();
        test.partition("aab");
    }

}
