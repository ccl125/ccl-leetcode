package util;

import java.util.Arrays;

/**
 * @Author: CuiChengLong
 * @Date: 2024/1/12 11:42
 * @Description
 */
public class QuickSort {

    public static void quickSort(int[] arr, int l, int r) {
        if (l >= r) return;
        int left = l, right = r;
        int pri = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pri) {
                right--;
            }
            // 不是 left < arr.length 是因为 left不需要超过right，本来就是左右对调，如果left比right的索引大了，就不需要对调了
            if (left < right) {
                arr[left] = arr[right];
            }
            while (left < right && arr[left] <= pri) {
                left++;
            }
            if (left < right) {
                arr[right] = arr[left];
            }
            //比基准元素小的都在左边，比基准元素大的都在右边，这时候left，right指针相交的地方就是最终基准元素的位置
            if (left >= right) {
                arr[left] = pri;
            }
        }
        // 这里的边界为什么是left-1和left+1 再下一轮调用中，已经根据基准元素分割成了左右两个数组，左边的都比基准元素小，右边都比基准元素大
        // 所以在下次去排序的时候，左侧子数组的范围就是l到left-1,右侧子数组的范围就是left+1到r。
        quickSort(arr, l, left - 1);
        quickSort(arr, left + 1, r);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 1, 0, 3, 5};
        int n = arr.length;
        //这里为什么传n-1，因为这里是去对arr里面索引0到n-1的元素去排序的，索引范围是n-1。而不是1到n
        quickSort(arr, 0, n - 1);
        System.out.println(Arrays.toString(arr));
    }

}
