package exam.leetcode374周赛;

import java.util.*;

/**
 * @Author CuiChengLong
 * @Date 2023/12/3 10:36
 * @Description
 */

public class t_2 {

    public  int minimumAddedCoins(int[] coins, int target) {
        // 先将coins进行升序排列
        Arrays.sort(coins);

        int i = 0; // 表示加入一个新的数-coins[0]
        int s = 1; // 能连续整数区间的最大值
        int ans = 0; // 需要添加几次s

        // 保证[0,s-1]区间大于等于[1,target]区间
        while (s <= target) {
            if (i < coins.length && coins[i] <= s) {
                // 此时 x <= s
                s += coins[i];
                ++i;
            } else {
                s += s; // 此时 x > s ，因此需要添加新元素s
                ++ans;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        t_2 t = new t_2();
        int[] coins = {1,4,10};
        int target = 19;
        int res = t.minimumAddedCoins(coins, target);
        System.out.println(res);
    }

}
