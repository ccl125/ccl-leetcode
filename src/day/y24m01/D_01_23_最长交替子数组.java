package day.y24m01;

/**
 * @Author: CuiChengLong
 * @Date: 2024/1/23 13:46
 * @Description
 */
public class D_01_23_最长交替子数组 {

    public static int alternatingSubarray(int[] nums) {
        int left = 0;
        int right = 1;
        int res = -1;
        while (left < nums.length && right < nums.length) {
            if (nums[right] == nums[left] + 1 && nums[right] == nums[right - 1] + 1) {
                right++;
                res = Math.max(res, right - left);
            } else if (nums[right] == nums[left] && nums[right] == nums[right - 1] - 1) {
                right++;
                res = Math.max(res, right - left);
            } else {
                left++;
                right = left + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {64,65,64,65,64,65,66,65,66,65};
//        int[] nums = {2,3,4,3,4};
        int[] nums = {6, 12, 2, 3, 8, 9, 10, 10, 2, 1}; // expect 2
//        int[] nums = {4,5,6}; // expect 2
//        int[] nums = {20,9,15,15};
        int[] nums2 = {1, 2, 2, 3, 2, 2, 2, 3, 2}; // expect 3
        System.out.println(alternatingSubarray(nums2));
    }
}
