package hot100.h4_子串;

import java.util.*;

/**
 * @Author: CuiChengLong
 * @Date: 2023/12/18 12:02
 * @Description
 */
public class H_滑动窗口最大值 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        for (int right = 0, left = 1 - k; right < nums.length; right++, left++) {
            if (left > 0 && queue.peekFirst() == nums[left - 1]) {
                queue.removeFirst();
            }
            while (!queue.isEmpty() && queue.peekLast() < nums[right]) {
                queue.removeLast();
            }
            queue.addLast(nums[right]);
            if (left >= 0) {
                res.add(queue.peekFirst());
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        H_滑动窗口最大值 test = new H_滑动窗口最大值();
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        test.maxSlidingWindow(nums, 3);
    }

}
