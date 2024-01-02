package day.y23m12;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: CuiChengLong
 * @Date: 2023/12/28 8:56
 * @Description 没理解题意
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

    public long minCostV2(int[] nums, int x) {
        int n = nums.length;
        int[] iMinCosts = new int[n];   // 记录每个类型巧克力的最小成本，初始为nums
        long costSum = 0;           	// 成本和，初始为nums元素和
        for(int i = 0; i < n; i++){
            costSum += nums[i];
            iMinCosts[i] = nums[i];
        }
        long res = costSum;        		// 记录最小成本，初始为起始成本和
        // 模拟n-1移动
        for(int k = 1; k < n; k++){
            costSum += x;   // 每次移动，成本增加x
            // 枚举每个类型巧克力的成本变换情况
            for(int i = 0; i < n; i ++){
                int newI = (n + i - k) % n;     // 类型i的巧克力当前的成本索引
                if(nums[newI] < iMinCosts[i]){
                    // 如果巧克力的成本变小，尝试用这个更小的成本
                    costSum += nums[newI] - iMinCosts[i];   // 成本和变换了新的成本和当前成本的差值
                    iMinCosts[i] = nums[newI];              // 记录最小差值
                }
            }
            res = Math.min(res, costSum);    // 移动一次后，更新最小成本
        }
        return res;
    }


    public static void main(String[] args) {
        D_12_28_收集巧克力 d = new D_12_28_收集巧克力();
        int[] nums = {20,1,15,12};
        int x = 1;
        System.out.println(d.minCostV2(nums, x));
    }

}
