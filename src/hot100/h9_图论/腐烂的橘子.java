package hot100.h9_图论;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: CuiChengLong
 * @Date: 2024/1/25 15:48
 * @Description DFS写的很丑陋，要用BFS
 */
public class 腐烂的橘子 {

    int[][] temp;

    class MyPoint{
        int x;
        int y;
        public int getX() {
            return x;
        }
        public int getY() {
            return y;
        }
        public MyPoint(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int orangesRotting(int[][] grid) {
        this.temp = new int[grid.length][grid[0].length];
        // 深拷贝
        for (int i = 0; i < temp.length; i++) {
            System.arraycopy(grid[i], 0, temp[i], 0, grid[0].length);
        }
        if (judgeCanRottenAll()) {
            return -1;
        }
        int minute = 0;
        while (!judgeIsOver(grid)) {
            minutePass(grid);
            minute++;
        }
        return minute;
    }

    // 时间流逝1分钟
    public void minutePass(int[][] grid) {
        List<MyPoint> list = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    list.add(new MyPoint(i, j));
                }
            }
        }
        for (MyPoint mkv : list) {
            helpMove(grid, mkv.getX(), mkv.getY());
        }
    }

    //腐烂大法
    public void helpMove(int[][] grid, int i, int j) {
        if (i + 1 < grid.length && grid[i + 1][j] == 1)
            grid[i + 1][j] = 2;
        if (i - 1 >= 0 && grid[i - 1][j] == 1)
            grid[i - 1][j] = 2;
        if (j + 1 < grid[0].length && grid[i][j + 1] == 1)
            grid[i][j + 1] = 2;
        if (j - 1 >= 0 && grid[i][j - 1] == 1)
            grid[i][j - 1] = 2;
    }

    // 判断当前分钟是否已经都腐烂了
    public boolean judgeIsOver(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    // 判断给定条件下，是否存在永远也无法腐烂的橘子
    public boolean judgeCanRottenAll() {
        // 从一个烂橘子深搜走一遍，全部标记，标记完后再深搜一遍，如果还有未标记的橘子返回-1
        boolean[][] bo = new boolean[this.temp.length][this.temp[0].length];
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[0].length; j++) {
                if (temp[i][j] == 2) {
                    dfs(i, j, bo);
                }
            }
        }
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[0].length; j++) {
                if (temp[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public void dfs(int i, int j, boolean[][] bo) {
        if (i < 0 || i >= temp.length || j < 0 || j >= temp[0].length || temp[i][j] == 0 || bo[i][j]) {
            return;
        }
        // 所有橘子标记为2
        temp[i][j] = 2;
        bo[i][j] = true;
        dfs(i + 1, j, bo);
        dfs(i - 1, j, bo);
        dfs(i, j - 1, bo);
        dfs(i, j + 1, bo);
    }

    public static void main(String[] args) {
        腐烂的橘子 test = new 腐烂的橘子();
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
        int[][] grid = new int[][]{{2,0,1,2,1,2}};
        System.out.println(test.orangesRotting(grid));
    }


}
