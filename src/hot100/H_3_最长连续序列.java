package hot100;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author CuiChengLong
 * @Date 2023/11/27 22:48
 * @Description https://leetcode.cn/problems/longest-consecutive-sequence/description/?envType=study-plan-v2&envId=top-100-liked
 */

public class H_3_最长连续序列 {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int length = 0;
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (set.contains(temp-1)) {
                continue;
            }
            while (set.contains(temp++)) {
                length++;
                maxLength = Math.max(maxLength, length);
            }
            length = 0;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        H_3_最长连续序列 h_3最长连续序列 = new H_3_最长连续序列();
//        int[] nums = {100, 4, 200, 1, 3, 2};
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(h_3最长连续序列.longestConsecutive(nums));
    }

}
