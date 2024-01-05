package day.y23m12;

/**
 * @Author: CuiChengLong
 * @Date: 2023/12/19 9:10
 * @Description
 */
public class D_12_19_寻找峰值2 {

    public int[] findPeakGrid(int[][] mat) {
        int left = 0;
        int right = mat.length - 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int maxIndex = findMax(mat[mid]);
            if (mat[mid][maxIndex] < mat[mid + 1][maxIndex]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return new int[]{left, findMax(mat[left])};
    }

    public int findMax(int[] arr) {
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[index]) {
                index = i;
            }
        }
        return index;
    }

}
