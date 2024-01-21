package exam.leetcode381周赛;

/**
 * @Author CuiChengLong
 * @Date 2024/1/21 11:03
 * @Description
 */

public class t_4 {

    public long[] countOfPairs(int n, int x, int y) {
        int min = Math.min(x, y);
        int max = Math.max(x, y);
        x = min;
        y = max;
        long[] res = new long[n];
        for (int i = 1; i <= n; i++) {
            helpMe(i, n, res, x, y);
        }
        return res;
    }

    //每个节点到其他节点的最小路径
    private void helpMe(int i, int n, long[] res, int x, int y) {
        for (int j = i + 1; j <= n; j++) {
            int temp = findMe2(i, j, x, y);
            res[temp - 1] += 2;
        }
    }

    private int findMe2(int i, int j, int x, int y) {
        int min = Math.min(Math.abs(j - x) + Math.abs(i - y) + 1, Math.abs(j - y) + Math.abs(i - x) + 1);
        return Math.min(j - i, min);

    }


}
