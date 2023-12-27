package hot100;

/**
 * @Author: CuiChengLong
 * @Date: 2023/12/20 12:39
 * @Description
 */
public class H_除自身以外数组的乘积 {

    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length+1];
        int[] suffix = new int[nums.length+1];
        prefix[0] = 1;
        suffix[suffix.length-1] = 1;
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i-1] * nums[i-1];
        }
        for (int i = suffix.length-2; i >=0 ; i--) {
            suffix[i] = suffix[i+1] * nums[i];
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = prefix[i] * suffix[i+1];
        }
        return res;
    }


    public static void main(String[] args) {
        H_除自身以外数组的乘积 h = new H_除自身以外数组的乘积();
//        int[] nums = {1, 2, 3, 4};
        int[] nums = {-1, 1, 0, -3, 3};
        int[] res = h.productExceptSelf(nums);
        for (int i : res) {
            System.out.println(i);
        }
    }

}
