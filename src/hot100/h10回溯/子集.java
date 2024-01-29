package hot100.h10回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: CuiChengLong
 * @Date: 2024/1/26 17:20
 * @Description
 */
public class 子集 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(nums, res, temp, 0);
        return res;
    }

    public void dfs(int[] nums, List<List<Integer>> res, List<Integer> temp, int index) {
        res.add(temp);
        for (int i = index; i < nums.length; i++) {
            temp.add(nums[index]);
            dfs(nums, res, temp, index + 1);
            temp.remove(nums[index]);
        }
    }

}
