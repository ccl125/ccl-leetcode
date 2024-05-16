package hot100.h10回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author CuiChengLong
 * @Date 2024/5/15 15:53
 * @Description
 */
public class 组合 {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(n, k, new ArrayList<>(), 1);
        return res;
    }

    public void dfs(int n, int k, List<Integer> temp, int start) {
        if (temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i <= n; i++) {
            temp.add(i);
            dfs(n, k, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }


}
