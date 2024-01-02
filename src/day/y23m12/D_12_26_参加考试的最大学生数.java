package day.y23m12;

/**
 * @Author: CuiChengLong
 * @Date: 2023/12/26 9:00
 * @Description
 */
public class D_12_26_参加考试的最大学生数 {

    public int maxStudents(char[][] seats) {
        //行
        int m = seats.length;
        //列
        int n = seats[0].length;
        int[][] dp = new int[m + 1][1 << n];
        for (int i = 1; i <= m; i++) {
            int invalid = 0;
            for (int j = 0; j < n; j++) {
                if (seats[i - 1][j] == '#') {
                    invalid |= 1 << j;
                }
            }

            for (int j = 0; j < (1 << n); j++) {
                int adjacentMask = j << 1;
                if ((j & invalid) != 0 || (j & adjacentMask) != 0) {
                    dp[i][j] = -1;
                    continue;
                }
                int theOtherAdjacentMask = j >> 1;
                for (int k = 0; k < (1 << n); k++) {
                    if (dp[i - 1][k] == -1) continue;
                    if ((k & adjacentMask) != 0 || (k & theOtherAdjacentMask) != 0) continue;
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][k] + Integer.bitCount(j));
                }
            }
        }

        int max = 0;
        for (int i = 0; i < 1 << n; i++) {
            max = Math.max(max, dp[m][i]);
        }
        return max;
    }

}
