package day.y24m01;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author: CuiChengLong
 * @Date: 2024/1/5 10:41
 * @Description
 */
public class D_01_05_队列中可以看到的人数 {

    //超时O(n2)40 / 42 个通过测试用例
    public int[] canSeePersonsCount(int[] heights) {
        int[] res = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            int max = Integer.MIN_VALUE;
            int ans = 0;
            for (int j = i + 1; j < heights.length; j++) {
                //如果最大的比当前的还大，后面不用加了，这个直接堵死了
                if (max > heights[i]) break;
                //后面的比最大的大，说明后面都是高的，没被堵住，直接能看到就加
                if (heights[j] > max) {
                    ans++;
                }
                //每次更新最大的值
                max = Math.max(max, heights[j]);
            }
            res[i] = ans;
        }
        //上面的没有考虑如果第一个就比当前的大，只能看到一个
        //如果每次当前后面的就已经比当前的大了。重置下答案为1
        for (int i = 0; i < heights.length - 1; i++) {
            if (heights[i + 1] > heights[i]) {
                res[i] = 1;
            }
        }
        return res;
    }

    public int[] canSeePersonsCount2(int[] height) {
        int[] res = new int[height.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = height.length - 1; i >= 0; i--) {
            int ans = 0;
            while (!stack.isEmpty() && height[i] >= stack.peek()) {
                ans++;
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ans++;
            }
            stack.push(height[i]);
            res[i] = ans;
        }
        return res;
    }



    public static void main(String[] args) {
        D_01_05_队列中可以看到的人数 test = new D_01_05_队列中可以看到的人数();
        int[] height = new int[]{10, 6, 8, 5, 11, 9};
        System.out.println(Arrays.toString(test.canSeePersonsCount2(height)));
    }

}
