package day.y23m11;

import java.util.Arrays;

/**
 * @Author: CuiChengLong
 * @Date: 2023/11/30 13:35
 * @Description
 */
public class D_11_30_确定两个字符串是否接近 {

    //1 长度相等，字母够包含
    //2 字母出现次数的集合相同
    //符合条件，返回true
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();
        int[] ans = new int[27];
        int[] ans2 = new int[27];
        for (int i = 0; i < c1.length; i++) {
            ans[c1[i] - 'a']++;
            ans2[c2[i] - 'a']++;
        }
        for (int i = 0; i < word1.length(); i++) {
            char c = word1.charAt(i);
            if (!word2.contains(String.valueOf(c))) {
                return false;
            }
        }
        Arrays.sort(ans);
        Arrays.sort(ans2);
        return Arrays.equals(ans, ans2);
    }

    public static void main(String[] args) {
        D_11_30_确定两个字符串是否接近 test = new D_11_30_确定两个字符串是否接近();
        System.out.println(test.closeStrings("aaabbbbccddeeeeefffff", "aaaaabbcccdddeeeeffff"));
    }



}
