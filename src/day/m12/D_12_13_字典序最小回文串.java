package day.m12;

/**
 * @Author CuiChengLong
 * @Date 2023/12/13 19:44
 * @Description
 */

public class D_12_13_字典序最小回文串 {

    public String makeSmallestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            char l = chars[left];
            char r = chars[right];
            if (l == r) {
                left++;
                right--;
            } else if (l < r) {
                chars[right] = l;
                left++;
                right--;
            } else {
                chars[left] = r;
                left++;
                right--;
            }
        }
        return new String(chars);
    }

}
