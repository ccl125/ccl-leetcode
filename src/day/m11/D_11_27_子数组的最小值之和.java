package day.m11;

import java.util.Stack;

/**
 * @Author CuiChengLong
 * @Date 2023/11/27 21:21
 * @Description <a href="https://leetcode.cn/problems/sum-of-subarray-minimums/description/?envType=daily-question&envId=2023-11-27">...</a>
 */

public class D_11_27_子数组的最小值之和 {

    private static final int MOD = 1000000007;

    public int sumSubarrayMins(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int n = arr.length;
        //元素辐射左边界
        int[] left = new int[n];
        //元素辐射右边界
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();
        //找到所有元素左边界
        for (int i = 0; i < n; i++) {
            //第一个小于等于下标i的元素的下标就是左边界
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            //最左边界-1
            if (stack.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();
        //找到所有元素右边界
        for (int i = n-1; i >= 0; i--) {
            //第一个小于下标i的元素的下标就是右边界
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            // 最右边界n
            if (stack.isEmpty()) {
                right[i] = n;
            } else {
                right[i] = stack.peek();
            }
            stack.push(i);
        }

        //计算贡献度
        long res = 0;
        for (int i = 0; i < n; i++) {
            res = (res + (long) (i - left[i]) * (right[i] - i) * arr[i]) % MOD;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        D_11_27_子数组的最小值之和 day = new D_11_27_子数组的最小值之和();
        int[] arr = {3, 1, 2, 4};
        System.out.println(day.sumSubarrayMins(arr));
    }

}
