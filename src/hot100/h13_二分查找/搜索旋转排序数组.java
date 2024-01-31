package hot100.h13_二分查找;

/**
 * @Author CuiChengLong
 * @Date 2024/1/30 22:23
 * @Description
 */

public class 搜索旋转排序数组 {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) return mid;
            if (nums[mid] >= nums[left]) {
                //左边有序
                if (nums[left] <= target && target < nums[mid] ) {
                    // target 在前面有序的数组内
                    right = mid - 1;
                }
                if (nums[left] > target) {
                    left = mid;
                } else if (nums[mid] < target) {
                    left = left + 1;
                } else {
                    return mid;
                }

            } else {
                //右边有序
                if (nums[mid] > target) {
                    right = right - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    return mid;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        搜索旋转排序数组 test = new 搜索旋转排序数组();
        int[] nums = new int[]{4,5,6,7,0,1,2};
        test.search(nums, 0);
    }

}
