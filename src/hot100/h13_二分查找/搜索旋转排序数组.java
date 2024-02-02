package hot100.h13_二分查找;

/**
 * @Author CuiChengLong
 * @Date 2024/1/30 22:23
 * @Description
 */

public class 搜索旋转排序数组 {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) return mid;
            //mid落在左边有序的数组上
            if (nums[mid] >= nums[right]) {
                //mid落在左边有序数组的情况下，target还在mid的左边，可以直接将right指针更新到mid - 1处
                //2种情况，1、target在left和mid中间，更新right = mid - 1
                //2、其他任何地方，都是更新left = mid + 1; 不需要考虑各个数据之间的关系，只要不是第一种情况都是更新left = mid + 1
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                //mid落在右边有序的数组上
                //2种情况，1、target在mid和right中间，left变成 mid + 1
                //2、除了1外的任何的其他地方，不需要判断数据之间的关系，只要target的位置不是第一种情况的，都是更新 right = mid - 1；
                // left right不断逼近答案，2的情况实际上就是把不符合的都去掉了。
                if (target <= nums[right] && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        搜索旋转排序数组 test = new 搜索旋转排序数组();
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        test.search(nums, 0);
    }

}
