package day.m12;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: CuiChengLong
 * @Date: 2023/12/28 8:56
 * @Description
 */
public class D_12_28_收集巧克力 {


    public long minCost(int[] nums, int x) {
        int[] res = new int[nums.length];
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(i, nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            int min = nums[i];
            for (Map.Entry<Integer, Integer> m : map.entrySet()) {
                int index = m.getKey();
                int value = m.getValue();
                int minInterval = Math.min(Math.abs(index - i), n - Math.abs(index - i));
                int cost = minInterval * x + value;
                min = Math.min(min, cost);
            }
            res[i] = min;
        }
        long ans = 0;
        for (int i = 0; i < res.length; i++) {
            ans += res[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        D_12_28_收集巧克力 d = new D_12_28_收集巧克力();
        int[] nums = {20,1,15,12};
        int x = 1;
        System.out.println(d.minCost(nums, x));
    }

}
