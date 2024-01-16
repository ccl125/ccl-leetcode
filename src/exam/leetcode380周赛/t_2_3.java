package exam.leetcode380周赛;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: CuiChengLong
 * @Date: 2024/1/15 18:53
 * @Description
 */
public class t_2_3 {

    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        char[] text = s.toCharArray();
        List<Integer> posA = kmp(text, a.toCharArray());
        List<Integer> posB = kmp(text, b.toCharArray());

        List<Integer> ans = new ArrayList<>();
        for (int i : posA) {
            int bi = lowerBound(posB, i);
            if (bi < posB.size() && posB.get(bi) - i <= k ||
                    bi > 0 && i - posB.get(bi - 1) <= k) {
                ans.add(i);
            }
        }
        return ans;
    }

    private List<Integer> kmp(char[] text, char[] pattern) {
        int m = pattern.length;
        int[] pi = new int[m];
        int c = 0;
        for (int i = 1; i < m; i++) {
            char v = pattern[i];
            while (c > 0 && pattern[c] != v) {
                c = pi[c - 1];
            }
            if (pattern[c] == v) {
                c++;
            }
            pi[i] = c;
        }

        List<Integer> res = new ArrayList<>();
        c = 0;
        for (int i = 0; i < text.length; i++) {
            char v = text[i];
            while (c > 0 && pattern[c] != v) {
                c = pi[c - 1];
            }
            if (pattern[c] == v) {
                c++;
            }
            if (c == m) {
                res.add(i - m + 1);
                c = pi[c - 1];
            }
        }
        return res;
    }

    // 开区间写法
    // 请看 https://www.bilibili.com/video/BV1AP41137w7/
    private int lowerBound(List<Integer> nums, int target) {
        int left = -1, right = nums.size(); // 开区间 (left, right)
        while (left + 1 < right) { // 区间不为空
            // 循环不变量：
            // nums[left] < target
            // nums[right] >= target
            int mid = (left + right) >>> 1;
            if (nums.get(mid) < target) {
                left = mid; // 范围缩小到 (mid, right)
            } else {
                right = mid; // 范围缩小到 (left, mid)
            }
        }
        return right;
    }

//    作者：灵茶山艾府
//    链接：https://leetcode.cn/problems/find-beautiful-indices-in-the-given-array-i/solutions/2603716/fei-bao-li-zuo-fa-kmper-fen-cha-zhao-pyt-0o8y/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

}
