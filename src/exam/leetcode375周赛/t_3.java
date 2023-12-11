package exam.leetcode375周赛;

import java.util.Arrays;

/**
 * @Author CuiChengLong
 * @Date 2023/12/10 11:02
 * @Description
 */

public class t_3 {

    public long countSubarrays(int[] nums, int k) {
        long res = 0;
        long count = 0;
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
        }
        Arrays.sort(temp);
        int max = temp[temp.length - 1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == max) {
                count++;
            }
            if (count == k) {
                res += nums.length - i-1;
                count = 0;
                continue;
            }
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] == max) {
                    count++;
                }
                if (count == k) {
                    res += nums.length - j;
                    count = 0;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        t_3 t = new t_3();
        int[] nums = {61,23,38,23,56,40,82,56,82,82,82,70,8,69,8,7,19,14,58,42,82,10,82,78,15,82};
        int k = 2;
        long res = t.countSubarrays(nums, k);
        System.out.println(res);
    }

}
