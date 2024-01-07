package hot100.h6_矩阵;

/**
 * @Author: CuiChengLong
 * @Date: 2023/12/29 12:23
 * @Description
 */
public class H_矩阵置零 {

    public void setZeroes(int[][] matrix) {
        int[][] temp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                temp[i][j] = matrix[i][j];
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (temp[i][j] == 0) helpMe(matrix, i, j);
            }
        }
    }

    private void helpMe(int[][] matrix, int i, int j) {
        int up = i - 1;
        int left = j - 1;
        int right = j + 1;
        int down = i + 1;
        while (up >= 0) {
            matrix[up][j] = 0;
            up--;
        }
        while (down < matrix.length) {
            matrix[down][j] = 0;
            down++;
        }
        while (left >= 0) {
            matrix[i][left] = 0;
            left--;
        }
        while (right < matrix[0].length) {
            matrix[i][right] = 0;
            right++;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        H_矩阵置零 test = new H_矩阵置零();
        test.setZeroes(matrix);
    }

}
