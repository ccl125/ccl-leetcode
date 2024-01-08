package day.y24m01;

import java.util.HashMap;

/**
 * @Author CuiChengLong
 * @Date 2024/1/7 15:21
 * @Description
 */

public class D_01_07_赎金信 {

    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = magazine.toCharArray();
        for (char aChar : chars) {
            if (map.containsKey(aChar)) {
                map.put(aChar, map.get(aChar) + 1);
            } else {
                map.put(aChar, 1);
            }
        }
        char[] c = ransomNote.toCharArray();
        for (char value : c) {
            if (!map.containsKey(value)) {
                return false;
            } else {
                Integer integer = map.get(value);
                if (integer < 1) return false;
                map.put(value, map.get(value) - 1);
            }
        }
        return true;
    }

}
