package exam.leetcode383周赛;

/**
 * @Author CuiChengLong
 * @Date 2024/2/4 10:37
 * @Description
 */

public class t_1 {

    public int returnToBoundaryCount(int[] nums) {
        int ans = 0;
        int res = 0;
        for (int num : nums) {
            ans += num;
            if (ans == 0) {
                res++;
            }
        }
        return res;
    }


}
