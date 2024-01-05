package hot100;

import java.util.Arrays;

/**
 * @Author CuiChengLong
 * @Date 2023/12/31 13:44
 * @Description
 */

public class H_旋转图像 {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //对角线翻转
        while (n-- > 0) {
            for (int i = 0; i < matrix.length; i++) {
                if (i >= n) {
                    break;
                }
                int temp = matrix[i][n];
                matrix[i][n] = matrix[n][i];
                matrix[n][i] = temp;
            }
        }
        //中心轴翻转
        int index = matrix.length / 2;
        for (int i = 0; i < index; i++) {
            for (int j = 0; j < matrix.length; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[j][matrix.length - 1 - i];
                matrix[j][matrix.length - 1 - i] = temp;
            }
        }
    }


    public static void main(String[] args) {
        H_旋转图像 test = new H_旋转图像();
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9},};
        test.rotate(matrix);
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

}
