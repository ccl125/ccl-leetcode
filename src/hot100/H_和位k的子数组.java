package hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author CuiChengLong
 * @Date 2023/12/7 23:17
 * @Description
 * 解题思路：
 *
 * 建立map表用于存储每个连续子数组sum求和出现的次数，初始化为（0,1），表示和为0的连续子数组出现1次。
 *
 * sum的值是在对nums数组的循环中不断累加当前元素的，res的值则需要查找map中是否已存在sum-k的元素，也就是在查找此前所有从0项开始累加的连续子项和中有没有sum-k。
 *
 * 如果有的话，则说明从该项到当前项的连续子数组和必定为k，那么res则可以和这个sum的对应值，即这个sum出现的次数，相加得到新的res。
 *
 * 对于当前sum如果已存在与map中则其对应值+1，不存在则添加新项，初始值为1。
 *
 */

public class H_和位k的子数组 {

    public int subarraySum(int[] nums, int k) {
        // key：前缀和，value：key 对应的前缀和的个数
        Map<Integer, Integer> preSumFreq = new HashMap<>();
        // 对于下标为 0 的元素，前缀和为 0，个数为 1
        preSumFreq.put(0, 1);

        int preSum = 0;
        int count = 0;
        for (int num : nums) {
            preSum += num;

            // 先获得前缀和为 preSum - k 的个数，加到计数变量里
            if (preSumFreq.containsKey(preSum - k)) {
                count += preSumFreq.get(preSum - k);
            }

            // 然后维护 preSumFreq 的定义
            preSumFreq.put(preSum, preSumFreq.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        H_和位k的子数组 test = new H_和位k的子数组();
        int[] nums = {1,1,1};
        int k = 2;
        int res = test.subarraySum(nums, k);
        System.out.println(res);
    }

    public int subarraySum2(int[] nums, int k) {
        int sum = 0, count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

}
