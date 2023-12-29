package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: CuiChengLong
 * @Date: 2023/12/29 12:51
 * @Description
 */
public class H_螺旋矩阵 {

    public List<Integer> spiralOrder(int[][] matrix) {
        boolean[][] temp = new boolean[matrix.length][matrix[0].length];
        List<Integer> res = new ArrayList<>();
        int sum = matrix.length * matrix[0].length;
        right(matrix, temp, res, 0, 0, sum);
        return res;
    }

    private void right(int[][] matrix, boolean[][] temp,
                       List<Integer> res, int i, int j, int sum) {
        res.add(matrix[i][j]);
        temp[i][j] = true;
        right(matrix, temp, res, i, j + 1, sum);
        if (res.size() >= sum) {
            return;
        }
        if (check(i, j, matrix) || !temp[i][j]) {
            down(matrix, temp, res, i + 1, j, sum);
        }
    }

    private void down(int[][] matrix, boolean[][] temp,
                      List<Integer> res, int i, int j, int sum) {
        if (res.size() >= sum) {
            return;
        }
        if (check(i, j, matrix) && !temp[i][j]) {
            left(matrix, temp, res, i, j - 1, sum);
        }
        res.add(matrix[i][j]);
        temp[i][j] = true;
        down(matrix, temp, res, i + 1, j, sum);
    }

    private void left(int[][] matrix, boolean[][] temp,
                      List<Integer> res, int i, int j, int sum) {
        if (res.size() >= sum) {
            return;
        }
        if (check(i, j, matrix) && !temp[i][j]) {
            up(matrix, temp, res, i - 1, j, sum);
        }
        res.add(matrix[i][j]);
        temp[i][j] = true;
        left(matrix, temp, res, i, j - 1, sum);
    }

    private void up(int[][] matrix, boolean[][] temp,
                    List<Integer> res, int i, int j, int sum) {
        if (res.size() >= sum) {
            return;
        }
        if (check(i, j, matrix) && !temp[i][j]) {
            right(matrix, temp, res, i, j + 1, sum);
        }
        res.add(matrix[i][j]);
        temp[i][j] = true;
        up(matrix, temp, res, i - 1, j, sum);
    }

    private boolean check(int i, int j, int[][] matrix) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        H_螺旋矩阵 test = new H_螺旋矩阵();
        int[][] matrix = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        System.out.println(test.spiralOrder(matrix));
    }

}
