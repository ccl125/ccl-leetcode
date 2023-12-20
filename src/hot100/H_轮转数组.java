package hot100;

import java.util.Arrays;

/**
 * @Author: CuiChengLong
 * @Date: 2023/12/20 9:41
 * @Description
 */
public class H_轮转数组 {

    public void rotate(int[] nums, int k) {
        if (nums.length < 2) return;
        int[] res = new int[nums.length];
        k %= nums.length;
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i];
        }
        int temp = nums.length - k;
        int index = 0;
        for (int i = temp; i < nums.length; i++) {
            nums[index++] = res[i];
        }
        for (int i = 0; i < temp; i++) {
            nums[index++] = res[i];
        }
    }

    public static void main(String[] args) {
        H_轮转数组 test = new H_轮转数组();
//        int[] nums = new int[]{1,2,3,4,5,6,7};
        int[] nums = new int[]{-1,-100,3,99};
        test.rotate(nums, 2);
    }

}
