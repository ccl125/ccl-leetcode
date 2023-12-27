package hot100;

import java.util.Arrays;

/**
 * @Author: CuiChengLong
 * @Date: 2023/12/22 9:22
 * @Description
 */
public class H_缺失的第一个正数 {

    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] > 1) return 1;
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                flag = true;
                break;
            }
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 1) {
                if (nums[i - 1] + 1 != nums[i]) return nums[i] - 1;
            }
        }
        if (!flag) return 1;
        return nums[nums.length - 1] + 1;
    }

    public static void main(String[] args) {
        H_缺失的第一个正数 test = new H_缺失的第一个正数();
//        int[] nums = new int[]{1, 2, 0};
//        int[] nums = new int[]{3, 4, -1, 1};
//        int[] nums = new int[]{7, 8, 9, 11, 12};
        int[] nums = new int[]{1};
        System.out.println(test.firstMissingPositive(nums));
    }

}
