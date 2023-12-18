package day.m12;

/**
 * @Author: CuiChengLong
 * @Date: 2023/12/18 9:17
 * @Description
 */
public class D_12_18_寻找峰值 {


    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left)/2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
