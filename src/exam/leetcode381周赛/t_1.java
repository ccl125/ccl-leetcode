package exam.leetcode381周赛;

import java.util.Arrays;

/**
 * @Author CuiChengLong
 * @Date 2024/1/21 10:35
 * @Description
 */

public class t_1 {

    public static int minimumPushes(String word) {
        if (word.length() < 9) return word.length();
        int length = word.length();
        int res = 0;
        int temp = 1;
        while (length >= 8) {
            res = res + (8 * temp);
            temp++;
            length -= 8;
        }
        return res + length * temp;
    }


}
