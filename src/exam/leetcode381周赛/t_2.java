package exam.leetcode381周赛;

/**
 * @Author CuiChengLong
 * @Date 2024/1/21 11:03
 * @Description
 */

public class t_2 {

    public int[] countOfPairs(int n, int x, int y) {
        int min = Math.min(x, y);
        int max = Math.max(x, y);
        x = min;
        y = max;
        int[] res = new int[n];
        for (int i = 1; i <= n; i++) {
            helpMe(i, n, res, x, y);
        }
        return res;
    }

    //每个节点到其他节点的最小路径
    private void helpMe(int i, int n, int[] res, int x, int y) {
        for (int j = i + 1; j <= n; j++) {
            int temp = findMe(i, j, x, y);
            res[temp - 1] += 2;
        }
    }

    //i到j的最短路径 错误，笨蛋
    private int findMe(int i, int j, int x, int y) {
        if (x == y) return j - i;
        if (i ==x && j == y) {
            return 1;
        }

        if (i <= x && j >= y) {
            int index1 = j - i;
            int index2 = (x - i) + 1 + (j - y);
            return Math.min(index2, index1);
        } else {
            int temp1 = Math.abs(x-j) + Math.abs(x - i);
            int temp2 = Math.abs(y-j) + Math.abs(y - i);
            int min = Math.min(temp2, temp1);
            return Math.min(min, j - i);
        }

    }

    public static void main(String[] args) {
        t_2 test = new t_2();
        test.countOfPairs(5, 1, 5);
    }


    public int[] countOfPairs2(int n, int x, int y) {
        x--;
        y--;
        int[] ans = new int[n];
        int[][] dis = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                dis[i][j] = Math.min(Math.abs(j - x) + Math.abs(i - y) + 1, Math.abs(j - y) + Math.abs(i - x) + 1);
                dis[i][j] = Math.min(i - j, dis[i][j]);
                ans[dis[i][j] - 1] += 2;
            }
        }
        return ans;
    }

    //这么简单想不到
    private int findMe2(int i, int j, int x, int y) {
        int min = Math.min(Math.abs(j - x) + Math.abs(i - y) + 1, Math.abs(j - y) + Math.abs(i - x) + 1);
        return Math.min(j - i, min);

    }


}
