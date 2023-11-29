package hot100;

import java.util.Arrays;

/**
 * @Author CuiChengLong
 * @Date 2023/11/28 20:35
 * @Description https://leetcode.cn/problems/move-zeroes/description/?envType=study-plan-v2&envId=top-100-liked
 */

public class H_4 {

    public void moveZeroes(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                swap(nums, right, left);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        H_4 test = new H_4();
        int[] nums = new int[]{0,1,0,3,12};
//        int[] nums = new int[]{1,0,1};
        test.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

}
