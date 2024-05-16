package hot100.h10回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author CuiChengLong
 * @Date 2024/5/15 15:27
 * @Description
 */
public class 组合总数2 {

    List<List<Integer>> res = new ArrayList<>();
    int flag = 0;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> temp = new ArrayList<>();
        //关键点1: 结果不重复，先排序
        //[1,3,2,3],target = 5的情况下，如果不排序，就会出现[3,2],[2,3]这样的答案
        //但是实际答案只有[2,3],因此要先排序，防止元素重复
        Arrays.sort(candidates);
        dfs(candidates, target, 0, temp);
        return res;
    }

    public void dfs(int[] candidates, int target, int index, List<Integer> temp) {
        if (flag > target) {
            //每次这里不用将flag置为0，如果置为0，那回溯的时候就会出问题，影响答案
            //比如1,2,4,19,6;当选完19发现比target大的时候，return回溯不选19就好了，而不应该把整个flag置为0
            return;
        }
        if (flag == target) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            //关键点2: 同一层相同元素，只能选一个
            //[1,2,3,3] target = 5的情况，在2遍历的过程中就会出现[2,3],[2,3]这样的答案
            //但是答案只有一个[2,3],因此，遇到相同的元素，要向后继续continue，防止重复
            if (i > index && candidates[i - 1] == candidates[i]) {
                continue;
            }
            temp.add(candidates[i]);
            flag += candidates[i];
            dfs(candidates, target, i + 1, temp);
            temp.remove(temp.size() - 1);
            flag -= candidates[i];
        }
    }

}
