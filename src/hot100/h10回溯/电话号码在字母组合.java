package hot100.h10回溯;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: CuiChengLong
 * @Date: 2024/1/26 17:45
 * @Description
 */
public class 电话号码在字母组合 {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        HashMap<Character, char[]> map = new HashMap<>();
        String[] temp = new String[]{"abc", "dfe", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for (int i = 2; i < 10; i++) {
            map.put((char) (i + 48), temp[i - 2].toCharArray());
        }
        String str = "";
        dfs(digits, res, 0, str, map);
        return res;
    }

    public void dfs(String digits, List<String> res, int index, String str, HashMap<Character, char[]> map) {
        if (digits.length() == str.length()) {
            res.add(str);
            return;
        }
        char[] c = map.get(digits.charAt(index));
        for (int i = 0; i < c.length; i++) {
            str += c[i];
            dfs(digits, res, index + 1, str, map);
            str = str.substring(0, str.length() -1);
        }
    }

    public static void main(String[] args) {
        电话号码在字母组合 test = new 电话号码在字母组合();
        System.out.println(test.letterCombinations("23"));
    }

}
