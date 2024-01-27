package hot100.h9_图论;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: CuiChengLong
 * @Date: 2024/1/26 17:19
 * @Description
 */
public class 全排列 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        qpl(nums, 0, res);
        return res;
    }

    public void qpl(int[] nums, int index, List<List<Integer>> res) {
        if (index == nums.length - 1) {
            List<Integer> temp = Arrays.stream(nums).boxed().collect(Collectors.toList());
            res.add(temp);
        }
        for (int i = index; i < nums.length; i++) {
            int temp = nums[i];
            nums[i] = nums[index];
            nums[index] = temp;
            qpl(nums, index + 1, res);
            temp = nums[i];
            nums[i] = nums[index];
            nums[index] = temp;
        }
    }

}
