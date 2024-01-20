package day.y24m01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author CuiChengLong
 * @Date 2024/1/20 11:49
 * @Description
 */

public class D_01_20_按分隔符拆分字符串 {

    public static List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> res = new ArrayList<>();
        for (String s : words) {
            List<String> temp = helpSplit(s, separator);
            res.addAll(temp);
        }
        return res;
    }

    private static List<String> helpSplit(String s, char separator) {
        List<String> res = new ArrayList<>();
        char[] chars = s.toCharArray();
        String str = "";
        for (int i = 0; i < chars.length; i++) {
            if ((chars[i] == separator && !"".equals(str))) {
                res.add(str);
                str = "";
            }
            if (chars[i] != separator) {
                str += chars[i];
            }
            if (!"".equals(str) && i == chars.length - 1) {
                res.add(str);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("one.two.three");
        words.add("four.five");
        words.add("six");
        System.out.println(splitWordsBySeparator(words, '.'));
    }

}
