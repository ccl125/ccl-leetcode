package day.y24m01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: CuiChengLong
 * @Date: 2024/1/30 10:50
 * @Description 取决于间隔最远的两个相邻的x，注意这个相邻，为什么是相邻的，不是每一个的，是因为只有相邻的距离是有效的，因为扩散的时候是
 * 一起扩散的，你间隔了不是相邻的，即使他们相同也不是不是计算答案的步骤
 */
public class D_01_30_使循环数组所有元素相等的最少秒数 {

    public int minimumSeconds(List<Integer> nums) {
        boolean flag = true;
        for (int i = 1; i < nums.size(); i++) {
            if (!nums.get(i - 1).equals(nums.get(i))) {
                flag = false;
                break;
            }
        }
        if (flag) return 0;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            map.put(nums.get(i), new ArrayList<>());
        }
        for (int i = 0; i < nums.size(); i++) {
            map.get(nums.get(i)).add(i);
        }
        int min = Integer.MAX_VALUE;
        for (Map.Entry<Integer, List<Integer>> data : map.entrySet()) {
            List<Integer> temp = data.getValue();
            int ans = findMin(temp, nums.size());
            min = Math.min(min, ans);
        }
        return min >= 2 ? min / 2 : nums.size() / 2;
    }

    public int findMin(List<Integer> temp, int n) {
        if (temp.size() < 2) {
            return n;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < temp.size(); i++) {
            int min = 0;
            for (int j = i + 1; j < temp.size(); j++) {
                int a = Math.abs(temp.get(i) - temp.get(j));
                int b = n - a;
                min = Math.min(a, b);
            }
            max = Math.max(max, min);
        }
        return max;
    }

    public static void main(String[] args) {
        D_01_30_使循环数组所有元素相等的最少秒数 test = new D_01_30_使循环数组所有元素相等的最少秒数();
        List<Integer> temp = new ArrayList<>();
//        temp.add(2);
        temp.add(5);
        temp.add(5);
        temp.add(5);
        temp.add(5);
        System.out.println(test.minimumSeconds(temp));
    }

}
