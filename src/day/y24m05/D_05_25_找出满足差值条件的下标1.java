package day.y24m05;

/**
 * @Author CuiChengLong
 * @Date 2024/5/25 11:57
 * @Description
 */
public class D_05_25_找出满足差值条件的下标1 {

    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (Math.abs(i - j) >= indexDifference && Math.abs(nums[i] - nums[j]) >= valueDifference) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

}
