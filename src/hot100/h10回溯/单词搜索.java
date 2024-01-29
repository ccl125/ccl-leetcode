package hot100.h10回溯;

/**
 * @Author: CuiChengLong
 * @Date: 2024/1/29 16:09
 * @Description
 */
public class 单词搜索 {

    boolean res = false;
    public boolean exist(char[][] board, String word) {
        int index = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(index)) {
                    dfs(i, j, board, word, index);
                }
            }
        }
        return res;
    }

    public void dfs(int i, int j, char[][] board, String word, int index) {
        if (i < 0 || j < 0
                || i >= board.length || j >= board[0].length
                || board[i][j] != word.charAt(index) || board[i][j] == '#') {
            return;
        }
        if (index == word.length() - 1) {
            res =  true;
            return;
        }
        char temp = board[i][j];
        board[i][j] = '#';
        dfs(i + 1, j, board, word, index + 1);
        dfs(i - 1, j, board, word, index + 1);
        dfs(i, j - 1, board, word, index + 1);
        dfs(i, j + 1, board, word, index + 1);
        board[i][j] = temp;
    }

    public static void main(String[] args) {
        单词搜索 test = new 单词搜索();
        char[][] board = new char[][]{{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'B', 'D'}};
        test.exist(board, "AAB");
    }

}
