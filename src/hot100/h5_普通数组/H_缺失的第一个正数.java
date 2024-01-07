package hot100.h5_普通数组;

/**
 * @Author: CuiChengLong
 * @Date: 2023/12/22 9:22
 * @Description
 */
public class H_缺失的第一个正数 {

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // 将数组中的数字放置到正确的位置上
        for (int i = 0; i < n; i++) {
            while (nums[i] >= 1 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        // 再次遍历数组，找到第一个不在正确位置上的数字
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // 如果数组中所有数字都在正确位置上，则返回下一个正整数
        return n + 1;
    }

    public static void main(String[] args) {
        H_缺失的第一个正数 test = new H_缺失的第一个正数();
//        int[] nums = new int[]{1,2,0};
        int[] nums = new int[]{3, 4, -1, 1};
//        int[] nums = new int[]{7, 8, 9, 11, 12};
//        int[] nums = new int[]{1};
        System.out.println(test.firstMissingPositive(nums));
    }

}
