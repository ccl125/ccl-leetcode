package day.m12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author CuiChengLong
 * @Date 2023/12/7 22:29
 * @Description
 */

public class D_12_07_重新规划路线 {

    private List<int[]>[] g;

    public int minReorder(int n, int[][] connections) {
        g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int[] e : connections) {
            int a = e[0], b = e[1];
            g[a].add(new int[] {b, 1});
            g[b].add(new int[] {a, 0});
        }
        return dfs(0, -1);
    }

    private int dfs(int a, int fa) {
        int ans = 0;
        for (int[] e : g[a]) {
            int b = e[0], c = e[1];
            if (b != fa) {
                ans += c + dfs(b, a);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        D_12_07_重新规划路线 d = new D_12_07_重新规划路线();
        int n = 6;
        int[][] connections = {{0,1},{1,3},{2,3},{4,0},{4,5}};
        int res = d.minReorder(n, connections);
        System.out.println(res);
    }

}
