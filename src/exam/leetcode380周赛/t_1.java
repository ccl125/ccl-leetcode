package exam.leetcode380周赛;

/**
 * @Author CuiChengLong
 * @Date 2024/1/14 10:26
 * @Description
 */

public class t_1 {

    public static int maxFrequencyElements(int[] nums) {
        int[] max = new int[105];
        for (int i = 0; i < nums.length; i++) {
            max[nums[i]]++;
        }
        int res = 0;
        for (int i = 0; i < max.length; i++) {
            res = Math.max(res, max[i]);
        }
        int ans = 0;
        for (int i = 0; i < max.length; i++) {
            if (max[i] == res) ans += max[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,3,4,5};
        System.out.println(maxFrequencyElements(nums));
    }

}
