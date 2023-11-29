package hot100;

import java.util.*;

/**
 * @Author CuiChengLong
 * @Date 2023/11/29 19:58
 * @Description https://leetcode.cn/problems/3sum/description/?envType=study-plan-v2&envId=top-100-liked
 */

public class H_6_三数之和 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> res = new HashSet<>();
        int k = 0;
        while (k < nums.length && nums[k] <= 0) {
            int i = k + 1;
            int j = nums.length - 1;
            if (k > 0 && nums[k] == nums[k - 1]) {
                k++;
                continue;
            }
            while (i < j) {
                if (nums[i] + nums[j] == -nums[k]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[k]);
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    res.add(temp);

                }
                if (nums[i] + nums[j] < -nums[k]) {
                    i++;
                } else {
                    j--;
                }
            }
            k++;
        }
        return new ArrayList<>(res);
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length<3) return res;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                } else if (sum < 0) l++;
                else r--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        H_6_三数之和 test = new H_6_三数之和();
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        System.out.println(test.threeSum(nums));
    }

}
