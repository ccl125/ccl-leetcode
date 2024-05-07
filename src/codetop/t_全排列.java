package codetop;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author CuiChengLong
 * @Date 2024/5/6 20:34
 * @Description
 */
public class t_全排列 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        qpl(nums, 0);
        return res;
    }

    public void qpl(int[] nums, int index) {
        if (index == nums.length - 1) {
            List<Integer> temp = add(nums);
            res.add(temp);
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            qpl(nums, index + 1);
            swap(nums, i, index);
        }
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public List<Integer> add(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            temp.add(nums[i]);
        }
        return temp;
    }

    public static void main(String[] args) {
        t_全排列 test = new t_全排列();
        test.permute(new int[]{1, 2, 3});
    }

}
