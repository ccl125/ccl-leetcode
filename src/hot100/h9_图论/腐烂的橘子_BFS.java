package hot100.h9_图论;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: CuiChengLong
 * @Date: 2024/1/25 17:43
 * @Description
 */
public class 腐烂的橘子_BFS {

    public int orangesRotting(int[][] grid) {
        int minute = 0;
        Queue<int[]> qu = new LinkedList<>();
        int goodSum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    qu.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    goodSum++;
                }
            }
        }
        if (goodSum == 0) {
            return 0;
        }
        if (qu.size() == 0) {
            return -1;
        }
        while (!qu.isEmpty()) {
            int n = qu.size();
            for (int i = 0; i < n; i++) {
                int[] temp = qu.poll();
                rottenOrange(grid, temp[0], temp[1], qu);
            }
            minute++;
        }

        if (hasOne(grid)) {
            return -1;
        }
        return minute > 0 ? minute - 1 : minute;

    }

    public void rottenOrange(int[][] grid, int i, int j, Queue<int[]> qu) {
        if (i + 1 < grid.length && grid[i + 1][j] == 1) {
            grid[i + 1][j] = 2;
            qu.offer(new int[]{i + 1, j});
        }
        if (i - 1 >= 0 && grid[i - 1][j] == 1) {
            grid[i - 1][j] = 2;
            qu.offer(new int[]{i - 1, j});
        }
        if (j + 1 < grid[0].length && grid[i][j + 1] == 1) {
            grid[i][j + 1] = 2;
            qu.offer(new int[]{i, j + 1});
        }
        if (j - 1 >= 0 && grid[i][j - 1] == 1) {
            grid[i][j - 1] = 2;
            qu.offer(new int[]{i, j - 1});
        }
    }

    public boolean hasOne(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        腐烂的橘子_BFS test = new 腐烂的橘子_BFS();
//        int[][] grid = new int[][]{
//                {2,0,1,1,1,1,1,1,1,1},
//                {1,0,1,0,0,0,0,0,0,1},
//                {1,0,1,0,1,1,1,1,0,1},
//                {1,0,1,0,1,0,0,1,0,1},
//                {1,0,1,0,1,0,0,1,0,1},
//                {1,0,1,0,1,1,0,1,0,1},
//                {1,0,1,0,0,0,0,1,0,1},
//                {1,0,1,1,1,1,1,1,0,1},
//                {1,0,0,0,0,0,0,0,0,1},
//                {1,1,1,1,1,1,1,1,1,1}};
//        int[][] grid = new int[][]{{2,0,1,2,1,2}};
//        int[][] grid = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
//        int[][] grid = new int[][]{{0,2}};
//        int[][] grid = new int[][]{{0,2}};
//        int[][] grid = new int[][]{{0}};
        int[][] grid = new int[][]{{1},{2}};
        System.out.println(test.orangesRotting(grid));
    }
}
