package hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author CuiChengLong
 * @Date 2023/11/27 21:29
 * @Description https://leetcode.cn/problems/two-sum/description/?envType=study-plan-v2&envId=top-100-liked
 */

public class H_1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> temp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (temp.containsKey(target - nums[i])) {
                return new int[]{temp.get(target - nums[i]), i};
            }
            temp.put(nums[i], i);
        }
        return new int[]{0, 0};
    }

}
