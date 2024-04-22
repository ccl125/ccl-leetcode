package util;

import java.util.Arrays;

/**
 * @Author CuiChengLong
 * @Date 2024/4/16 20:47
 * @Description
 */

public class QuickSort2 {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 1, 0, 3, 5};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int l = left;
        int r = right;
        int pri = arr[left];
        while (l < r) {
            while (l < r && arr[r] >= pri) {
                r--;
            }
            if (l < r) {
                arr[l] = arr[r];
            }
            while (l < r && arr[l] <= pri) {
                l++;
            }
            if (l < r) {
                arr[r] = arr[l];
            }
            if (l >= r) {
                arr[l] = pri;
            }
        }
        quickSort(arr, left, l - 1);
        quickSort(arr, l + 1, right);
    }

}
