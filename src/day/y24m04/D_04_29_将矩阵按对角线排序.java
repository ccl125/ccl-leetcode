package day.y24m04;

import java.util.PriorityQueue;

/**
 * @Author CuiChengLong
 * @Date 2024/4/29 00:59
 * @Description
 */
public class D_04_29_将矩阵按对角线排序 {

    int relRow;
    int relColumn;
    public int[][] diagonalSort(int[][] mat) {
        this.relRow = mat.length;
        this.relColumn = mat[0].length;
        for (int i = 0; i < relRow; i++) {
            for (int j = 0; j < relColumn; j++) {
                if (i == 0 || j == 0) {
                    sort(mat, i, j);
                }
            }
        }
        return mat;
    }
    public void sort(int[][] mat, int row, int column) {
//        TreeSet<Integer> set = new TreeSet<>();
        PriorityQueue<Integer> set = new PriorityQueue<>();
        int saveRow = row;
        int saveColumn = column;
        while (row < relRow && column < relColumn) {
            set.add(mat[row++][column++]);
        }
        while (saveRow < relRow && saveColumn < relColumn) {
            mat[saveRow++][saveColumn++] = set.poll();
        }
    }

}
