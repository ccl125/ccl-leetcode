package hot100.h10回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author CuiChengLong
 * @Date 2024/5/14 22:42
 * @Description
 */
public class 组合总数3 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    // 判断当前的组合
    int flag = 0;
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(k, n, 1);
        return res;
    }

    public void dfs(int k, int n, int start) {
        // 当k个数等于n的时候记录答案
        if (temp.size() == k && flag == n) {
            res.add(new ArrayList<>(temp));
        }
        // 从1-9选择数
        for (int i = start; i <= 9; i++) {
            temp.add(i);
            flag += i;
            //不能重复，下次从i + 1开始
            dfs(k, n, i + 1);
            //回溯
            temp.remove(temp.size() - 1);
            flag -= i;
        }
    }

}
