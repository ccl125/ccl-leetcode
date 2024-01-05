package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: CuiChengLong
 * @Date: 2023/12/29 12:51
 * @Description [0][0]、[0][1]、[0][2] 0行，123列
 * [0][0]、[1][0]、[2][0] 0列，123行
 */
public class H_螺旋矩阵 {

    //列
    int column = 0;
    //行
    int row = 0;

    public List<Integer> spiralOrder(int[][] matrix) {
        boolean[][] temp = new boolean[matrix.length][matrix[0].length];
        List<Integer> res = new ArrayList<>();
        int sum = matrix.length * matrix[0].length;
        while (res.size() < sum) {
            dfsRight(matrix, temp, res);
            dfsDown(matrix, temp, res);
            dfsLeft(matrix, temp, res);
            dfsUp(matrix, temp, res);
        }
        return res;
    }

    private void dfsUp(int[][] matrix, boolean[][] temp, List<Integer> res) {
        //往上走，记录已走过的位置
        while (row >= 0 && !temp[row][column]) {
            res.add(matrix[row][column]);
            temp[row][column] = true;
            row--;
        }
        //如果已经走过或者越界，回退一步,row++是行回退，column++ 列加是继续向右走
        if (row == -1 || temp[row][column]) {
            row++;
            column++;
        }
    }

    private void dfsLeft(int[][] matrix, boolean[][] temp, List<Integer> res) {
        //往左走，记录已走过的位置
        while (column >= 0 && !temp[row][column]) {
            res.add(matrix[row][column]);
            temp[row][column] = true;
            column--;
        }
        //如果已经走过或者越界，回退一步,column++是回退，row--是继续向上走
        if (column == -1 || temp[row][column]) {
            column++;
            row--;
        }
    }

    private void dfsDown(int[][] matrix, boolean[][] temp, List<Integer> res) {
        //往下走，记录已走过的位置
        while (row < matrix.length && !temp[row][column]) {
            res.add(matrix[row][column]);
            temp[row][column] = true;
            row++;
        }
        //如果已经走过或者越界，回退一步,row--是行回退，column-- 列减是继续向左走
        if (row == matrix.length || temp[row][column]) {
            row--;
            column--;
        }
    }

    private void dfsRight(int[][] matrix, boolean[][] temp, List<Integer> res) {
        //往右走，记录已走过的位置
        while (column < matrix[0].length && !temp[row][column]) {
            res.add(matrix[row][column]);
            temp[row][column] = true;
            column++;
        }
        //如果已经走过或者越界，回退一步,column--是回退，row++是继续向下走
        if (column == matrix[0].length || temp[row][column]) {
            column--;
            row++;
        }
    }

    public static void main(String[] args) {
        H_螺旋矩阵 test = new H_螺旋矩阵();
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        System.out.println(test.spiralOrder(matrix));
    }

}
