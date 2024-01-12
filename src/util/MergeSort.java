package util;

import java.util.Arrays;

/**
 * @Author: CuiChengLong
 * @Date: 2024/1/12 11:43
 * @Description
 * 归并排序中间merge怎么理解？
 * 首先是比较temp左右子数组，将较小的元素拿出来，放在原始数组的指定位置，然后再移动拿走的temp左右子数组的指针，如果拿走的是左子数组，就移动左子数组的指针
 * 当左右指针的某一个已经越过左右子数组的边界的时候，更新数组只需要更新还没越界的即可，因为在比较的过程中左右子数组都是有序的。
 */
public class MergeSort {

    // 合并两个有序数组的方法
    public static void merge(int[] arr, int left, int middle, int right) {
        // 创建一个临时数组，用于存储待合并的元素
        int[] temp = new int[right - left + 1];

        // 将原始数组的一部分复制到临时数组中
        if (right + 1 - left >= 0) {
            System.arraycopy(arr, left, temp, 0, right + 1 - left);
        }

        // 初始化两个指针，分别指向两个子数组的起始位置
        int i = left, j = middle + 1;

        // 合并两个有序数组
        for (int k = left; k <= right; k++) {
            // 如果 i 超过了左子数组的末尾，将右子数组的元素放入原始数组
            if (i > middle && j <= right) {
                arr[k] = temp[j - left];
                j++;
            }
            // 如果 j 超过了右子数组的末尾，将左子数组的元素放入原始数组
            else if (j > right && i <= middle) {
                arr[k] = temp[i - left];
                i++;
            }
            // 比较左右子数组的元素，将较小的元素放入原始数组
            else if (temp[i - left] > temp[j - left]) {
                arr[k] = temp[j - left];
                j++;
            } else {
                arr[k] = temp[i - left];
                i++;
            }
        }
    }

    // 对 arr 数组中下标为 left 到下标为 right 的元素进行排序
    public static void mergeSort(int[] arr, int left, int right) {
        // 如果 left 大于等于 right，表示数组已经有序或为空，直接返回
        if (left >= right) {
            return;
        }

        // 计算中间位置
        int middle = (right + left) / 2;

        // 递归调用 mergeSort 对左右两个子数组进行排序
        mergeSort(arr, left, middle);
        mergeSort(arr, middle + 1, right);

        // 合并两个有序子数组
        merge(arr, left, middle, right);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7, 3, 2, 6, 0, 1, 5, 4};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

}
