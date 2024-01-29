package hot100.h10回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: CuiChengLong
 * @Date: 2024/1/29 18:16
 * @Description
 */
public class N皇后 {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] space = new char[n][n];
        for (char[] tmp : space) {
            Arrays.fill(tmp, '.');
        }
        dfs(res, n, space, 0);
        return res;
    }

    public void dfs(List<List<String>> res, int n, char[][] space, int row) {
        if (row == n) {
            res.add(Array2List(space));
        }
        for (int i = 0; i < n; i++) {
            if (isValid(i, row, space, n)) {
                space[row][i] = 'Q';
                dfs(res, n, space, row + 1);
                space[row][i] = '.';
            }
        }
    }

    public boolean isValid(int column, int row, char[][] space, int n) {
        //检查列
        for (int i = 0; i < n; i++) {
            if (space[i][column] == 'Q') {
                return false;
            }
        }

        // 检查45度对角线,下面还没放置，所以下面不用检查
        for (int i = row - 1, j = column - 1; i >= 0 && j >= 0; i--, j--) {
            if (space[i][j] == 'Q') {
                return false;
            }
        }

        // 检查135度对角线
        for (int i = row-1, j = column + 1; i >= 0 && j <= n-1; i--, j++) {
            if (space[i][j] == 'Q') {
                return false;
            }
        }
        return true;

    }

    public List Array2List(char[][] chessboard) {
        List<String> list = new ArrayList<>();

        for (char[] c : chessboard) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }

    public static void main(String[] args) {
        N皇后 test = new N皇后();
        test.solveNQueens(4);
    }

}
