package day.y24m01;

/**
 * @Author: CuiChengLong
 * @Date: 2024/1/31 11:18
 * @Description
 */
public class D_01_31_找到不同元素数目差数组 {

    public int[] distinctDifferenceArray(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int left = i;
            int right = i;
            int ans1 = 0;
            int ans2 = 0;
            while (left >= 0) {
                if (nums[left] != nums[i]) {
                    ans1++;
                }
                left--;
            }
            while (right < nums.length) {
                if (nums[right] != nums[i]) {
                    ans2++;
                }
                right++;
            }
            System.out.println("left = " + ans1 + " right = " + ans2);
            res[i] = ans1 - ans2;
        }
        return res;
    }

    public static void main(String[] args) {
        D_01_31_找到不同元素数目差数组 test = new D_01_31_找到不同元素数目差数组();
        int[] nums = new int[]{1,2,3,4,5};
        test.distinctDifferenceArray(nums);

    }

}
