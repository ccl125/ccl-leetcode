package exam.leetcode377周赛;

import java.util.Arrays;

/**
 * @Author CuiChengLong
 * @Date 2023/12/24 10:40
 * @Description
 */

public class t_1 {

    public int[] numberGame(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.sort(nums);
        int right = 1;
        int left = 0;
        int index = 0;
        while (right < nums.length && left < nums.length) {
            res[index++] = nums[right];
            res[index++] = nums[left];
            left += 2;
            right += 2;
        }
        return res;
    }

    public static void main(String[] args) {
        t_1 test = new t_1();
        int[] nums = new int[]{2,5};
        ;
        System.out.println(Arrays.toString(test.numberGame(nums)));
    }

}
