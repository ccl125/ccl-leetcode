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
    int flag = 0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> temp = new ArrayList<>();
        dfs(candidates, target, 0, temp);
        return res;
    }

    public void dfs(int[] candidates, int target, int index, List<Integer> temp) {
        //剪枝
        if (flag > target || index >= candidates.length) {
            return;
        }
        //记录答案
        if (flag == target) {
            res.add(new ArrayList<>(temp));
            return;
        }
        //每次循环从index开始，避免重复的组合
        for (int i = index; i < candidates.length; i++) {
            flag += candidates[i];
            temp.add(candidates[i]);
            //下次递归选取的index还要从i开始，因为一个元素可能重复选取
            dfs(candidates, target, i, temp);
            //回溯
            temp.remove(temp.size() - 1);
            flag -= candidates[i];
        }
    }

}
