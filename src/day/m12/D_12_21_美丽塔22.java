package day.m12;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: CuiChengLong
 * @Date: 2023/12/21 8:47
 * @Description
 */
public class D_12_21_美丽塔22 {

    public long maximumSumOfHeights(List<Integer> maxHeights) {
        long[] preSum = new long[maxHeights.size() + 1];
        long[] tailSum = new long[maxHeights.size() + 1];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int size = maxHeights.size();
        for (int i = 1; i <= size; i++) {
            long cur = maxHeights.get(i - 1);
            while (!stack.isEmpty() && cur < maxHeights.get(stack.peek())) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                int preIndex = stack.peek();
                preSum[i] = preSum[preIndex + 1] + (i - preIndex - 1) * cur;
            } else {
                preSum[i] = i * cur;
            }
            stack.push(i - 1);
        }
        stack.clear();
        for (int i = size - 1; i >= 0; i--) {
            long cur = maxHeights.get(i);
            while (!stack.isEmpty() && cur < maxHeights.get(stack.peek())) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                int nextIndex = stack.peek();
                tailSum[i] = tailSum[nextIndex] + (nextIndex - i) * cur;
            } else {
                tailSum[i] = (size - i) * cur;
            }
            stack.push(i);
        }
        long max = 0;
        for (int i = 0; i < size; i++) {
            max = Math.max(max, preSum[i + 1] + tailSum[i + 1]);
        }
        return max;
    }




    public static void main(String[] args) {
        D_12_21_美丽塔22 test = new D_12_21_美丽塔22();
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(3);
        list.add(4);
        list.add(1);
        list.add(1);
        System.out.println(test.maximumSumOfHeights(list));
    }

}
