package day.y23m12;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: CuiChengLong
 * @Date: 2023/12/20 9:04
 * @Description
 */
public class D_12_20_判别首字母缩略词 {

    public boolean isAcronym(List<String> words, String s) {
        String str = "";
        for (String word : words) {
            str += word.charAt(0);
        }
        return s.equals(str);
    }

    public static void main(String[] args) {
        D_12_20_判别首字母缩略词 test = new D_12_20_判别首字母缩略词();
        List<String> words = new ArrayList<>();
        words.add("alice");
        words.add("bob");
        words.add("charlie");
        test.isAcronym(words, "abc");
    }

}
