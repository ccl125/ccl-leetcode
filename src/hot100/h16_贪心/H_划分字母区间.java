package hot100.h16_贪心;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author CuiChengLong
 * @Date 2024/4/4 6:57
 * @Description
 */

public class H_划分字母区间 {

    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int[] map = new int[26];
        //记录每个字母最后出现的位置
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a'] = i;
        }
        int start = 0, scannerCharMaxPos = 0;
        for (int i = 0; i < s.length(); i++) {
            int currentCharMaxPos = map[s.charAt(i) - 'a'];
            //以遍历的字母最后出现位置的最大值
            scannerCharMaxPos = Math.max(scannerCharMaxPos, currentCharMaxPos);
            //如果当前遍历到的位置正好等于最大值，那么贪心的思想，为一次分割片段
            if (i == scannerCharMaxPos) {
                res.add(i - start + 1);
                start = i + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        H_划分字母区间 test = new H_划分字母区间();
        test.partitionLabels("ababcbacadefegdehijhklij");
    }

}
