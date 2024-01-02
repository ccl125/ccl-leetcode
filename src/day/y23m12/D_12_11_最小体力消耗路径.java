package day.y23m12;

import java.util.Arrays;

/**
 * @Author CuiChengLong
 * @Date 2023/12/11 21:02
 * @Description https://leetcode.cn/problems/path-with-minimum-effort/solutions/2561910/zui-xiao-ti-li-xiao-hao-lu-jing-by-zong-p8k9i/?envType=daily-question&envId=2023-12-11#%E6%80%9D%E8%B7%AF
 */

public class D_12_11_最小体力消耗路径 {

    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        int left = 0;
        int right = (int) Math.pow(10, 6);

        boolean[][] visited = new boolean[rows][cols];

        while (left < right) {
            int mid = left + (right - left) / 2;
            for (boolean[] row : visited) {
                Arrays.fill(row, false);
            }
            visited[0][0] = true;

            if (dfs(0, 0, mid, heights, visited)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean dfs(int x, int y, int limit, int[][] heights, boolean[][] visited) {
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        if (x == rows - 1 && y == cols - 1) {
            return true;
        }

        for (int[] dir : directions) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && !visited[nx][ny]) {
                int diff = Math.abs(heights[x][y] - heights[nx][ny]);
                if (diff <= limit) {
                    visited[nx][ny] = true;
                    if (dfs(nx, ny, limit, heights, visited)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }




}
