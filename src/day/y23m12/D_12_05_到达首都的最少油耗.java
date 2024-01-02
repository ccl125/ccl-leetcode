package day.y23m12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author CuiChengLong
 * @Date 2023/12/5 20:28
 * @Description
 */

public class D_12_05_到达首都的最少油耗 {

    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] e : roads) {
            int x = e[0], y = e[1];
            g[x].add(y); // 记录每个点的邻居
            g[y].add(x);
        }
        List<Integer> integers = g[0];

        dfs(0, -1, g, seats);
        return ans;
    }

    private long ans;

    private int dfs(int x, int fa, List<Integer>[] g, int seats) {
        int size = 1;
        for (int y : g[x]) {
            if (y != fa) { // 递归子节点，不能递归父节点
                size += dfs(y, x, g, seats); // 统计子树大小
            }
        }
        if (x > 0) { // x 不是根节点
            ans += (size - 1) / seats + 1; // ceil(size/seats)
        }
        return size;
    }

    public static void main(String[] args) {
        D_12_05_到达首都的最少油耗 d = new D_12_05_到达首都的最少油耗();
        int[][] roads = {{0,1},{0,2},{0,3}};
        int seats = 5;
        long res = d.minimumFuelCost(roads, seats);
        System.out.println(res);
    }


}
