package day.y23m12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: CuiChengLong
 * @Date: 2023/12/21 8:47
 * @Description
 */
public class D_12_21_美丽塔2 {

    long res;
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int[] arr = new int[maxHeights.size()];
        int[] add = new int[maxHeights.size()];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < maxHeights.size(); i++) {
            arr[i] = maxHeights.get(i);
            add[i] = maxHeights.get(i);
            max = Math.max(max, arr[i]);
        }
        for (int i = 0; i < maxHeights.size(); i++) {
            findMax(i, arr, add);
        }
        System.out.println(Arrays.toString(arr));
        return res;
    }


    public void findMax(int maxIndex, int[] arr, int[] add) {
        int right = maxIndex + 1;
        int left = maxIndex - 1;
        while (right < arr.length) {
            arr[right] = Math.min(arr[right - 1], arr[right]);
            right++;
        }
        while (left >= 0) {
            arr[left] = Math.min(arr[left + 1], arr[left]);
            left--;
        }
        long ans = 0;
        for (int j : arr) {
            ans += j;
        }
        res = Math.max(res, ans);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = add[i];
        }
    }


    public static void main(String[] args) {
        D_12_21_美丽塔2 test = new D_12_21_美丽塔2();
        List<Integer> list = new ArrayList<>();
        list.add(6);
        list.add(5);
        list.add(2);
        list.add(1);
        list.add(5);
        list.add(4);
        list.add(4);
        list.add(2);
        System.out.println(test.maximumSumOfHeights(list));
    }

}
