package hot100.h6_矩阵;

 /**
 * @Author: CuiChengLong
 * @Date: 2024/1/3 11:10
 * @Description 从右上角看，可以看作是一个二叉查找树
 */
public class H_搜索二维矩阵2 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int column = matrix[0].length - 1;
        while (row < matrix.length && column >= 0) {
            if (matrix[row][column] > target) {
                //排除整个右边列
                column--;
            } else {
                //当前列的所有开始查找
                for (int i = row; i < matrix.length; i++) {
                    if (matrix[i][column] == target) return true;
                }
                //可以排除上一行
                row++;
            }
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        int row = 0;
        int column = matrix[0].length - 1;
        while (row < matrix.length && column >= 0) {
            if (matrix[row][column] > target) {
                //排除整个右边列
                column--;
            } else if (matrix[row][column] < target){
                //可以排除上一行
                row++;
            } else {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        H_搜索二维矩阵2 test = new H_搜索二维矩阵2();
        int[][] matrix = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        System.out.println(test.searchMatrix(matrix, 20));
    }

}
