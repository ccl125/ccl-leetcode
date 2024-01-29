package hot100.h10回溯;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: CuiChengLong
 * @Date: 2024/1/29 15:27
 * @Description
 */
public class 括号生成 {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        String str = "";
        dfs(res, n, str, 0, 0);
        return res;
    }

    private void dfs(List<String> res, int n, String str, int left, int right) {
        if (left > n || right > left) {
            return;
        }
        if (left == n && right == n) {
            res.add(str);
        }
        dfs(res, n,str + "(", left + 1, right);
        dfs(res, n , str + ")", left, right + 1);
    }

}
