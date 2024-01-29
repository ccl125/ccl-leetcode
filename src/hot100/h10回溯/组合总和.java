package hot100.h10回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author CuiChengLong
 * @Date 2024/1/27 19:50
 * @Description
 */

public class 组合总和 {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> temp = new ArrayList<>();
        dfs(candidates, temp, target, 0);
        return res;
    }

    public void dfs(int[] candidates, List<Integer> temp, int target, int index) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(temp));
        }
        for (int i = index; i < candidates.length; i ++) {
            temp.add(candidates[index]);
            dfs(candidates, temp, target - candidates[index], index);
            temp.remove();
        }
    }

}
