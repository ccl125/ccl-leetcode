package day.y23m12;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author CuiChengLong
 * @Date 2023/12/11 21:21
 * @Description
 */

public class D_12_11_最小体力消耗路径_2 {

    private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int left = 0, right = 999999, ans = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0, 0});
            int[] seen = new int[m * n];
            seen[0] = 1;

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];

                for (int[] dir : dirs) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];

                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && seen[nx * n + ny] == 0 &&
                            Math.abs(heights[x][y] - heights[nx][ny]) <= mid) {
                        queue.add(new int[]{nx, ny});
                        seen[nx * n + ny] = 1;
                    }
                }
            }

            if (seen[m * n - 1] == 1) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}
