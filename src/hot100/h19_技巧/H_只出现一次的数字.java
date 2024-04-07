package hot100.h19_技巧;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author CuiChengLong
 * @Date 2024/4/6 18:09
 * @Description
 */

public class H_只出现一次的数字 {

    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], 2);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return 0;
    }

}
