package hot100.h13_二分查找;

/**
 * @Author: CuiChengLong
 * @Date: 2024/1/30 17:48
 * @Description 两次二分，第一次求前面第一个元素，二分返回right或者left都可以，因为最后left == right
 * 第二次二分求最后一个元素，二分的target变成target + 1，这样求到的left的位置就是最后一个的位置
 */
public class H_第一个和最后一个元素 {

    public int[] searchRange(int[] nums, int target) {
        int start = lowerBound(nums, target); // 选择其中一种写法即可
        if (start == nums.length || nums[start] != target) {
            return new int[]{-1, -1};
        }
        // 如果 start 存在，那么 end 必定存在
        int end = lowerBound(nums, target + 1) - 1;
        return new int[]{start, end};
    }
    private int lowerBound(int[] nums, int target) {
        int left = 0, right = nums.length; // 左闭右开区间 [left, right)
        while (left < right) { // 区间不为空
            // 循环不变量：
            // nums[left-1] < target
            // nums[right] >= target
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1; // 范围缩小到 [mid+1, right)
            } else {
                right = mid; // 范围缩小到 [left, mid)
            }
        }
        return left; // 返回 left 还是 right 都行，因为循环结束后 left == right
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 3};
        H_第一个和最后一个元素 test = new H_第一个和最后一个元素();
        test.searchRange(nums, 1);
    }

}
