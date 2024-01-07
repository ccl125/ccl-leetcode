package exam.leetcode379周赛;

import java.util.*;

/**
 * @Author CuiChengLong
 * @Date 2024/1/7 11:37
 * @Description
 */

public class t_3 {

    public int maximumSetSize(int[] nums1, int[] nums2) {
        // 正难则反，变为两个数组各取一半加到新数组里要求新数组里元素种类数最多；
        // 则先加非交集，再加交集；
        int n = nums1.length / 2;
        Set<Integer> set = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();
        for (int x : nums1) {
            set.add(x);
            set1.add(x);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int x : nums2) {
            set.add(x);
            set2.add(x);
        }
        //数组删除n个元素后，最多能保留的元素种类数为n和set1.size(）的最小值；
        // 每个集合移除后还剩下多少个，答案在length/2与不重合的元素之间
        // 取最小值（就是比如集合1,2,3,4 但是最终答案也是1,2。而不是1,2,3,4因为要去除length/2个，不重复的再多，能贡献给最终答案的最多也是length/2个）
        int x = Math.min(set1.size(), n);
        int y = Math.min(set2.size(), n);
        //set.size是所有不重复的，x+y是移除后最多包含的，答案不可能超过set.size()
        //取最小值
        return Math.min(set.size(), x + y);
    }

    public static void main(String[] args) {
//        int[] num1 = new int[]{1,2,1,1};
//        int[] num2 = new int[]{1,2,3,4};
        int[] num1 = new int[]{1, 2, 3, 4, 5, 6};
        int[] num2 = new int[]{1, 1, 1, 1, 1, 1};
        t_3 test = new t_3();
        System.out.println(test.maximumSetSize(num1, num2));
    }

}
