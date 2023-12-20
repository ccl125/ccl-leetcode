package hot100;

/**
 * @Author: CuiChengLong
 * @Date: 2023/12/20 12:39
 * @Description
 */
public class H_除自身以外数组的乘积 {

    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int[] res = new int[nums.length];
        int temp =1;
        for (int i = 0; i < nums.length; i++) {
            temp*=ans[i];
            ans[i] = temp;
        }
        for (int i = 0; i < nums.length; i++) {

        }
        return null;
    }

}
