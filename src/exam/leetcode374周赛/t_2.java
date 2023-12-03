package exam.leetcode374周赛;

import java.util.*;

/**
 * @Author CuiChengLong
 * @Date 2023/12/3 10:36
 * @Description
 */

public class t_2 {

    public int minimumAddedCoins(int[] coins, int target) {
        List<Integer> temp = new ArrayList<>();
        int res = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = i + 1; j < coins.length; j++) {
                temp.add(coins[i] + coins[j]);
            }
        }
        for (int i = 1; i <= target; i++) {
            if (!temp.contains(i)) {
                res++;
                temp.add(i);
                help(temp, i);
            }
        }
        return res - 1;
    }

    public void help(List<Integer> temp, int target) {
        int size = temp.size();
        for (int i = 0; i < size; i++) {
            temp.add(temp.get(i) + target);
        }
    }

    public static void main(String[] args) {
        t_2 t = new t_2();
        int[] coins = {1,1,1};
        int target = 20;
        int res = t.minimumAddedCoins(coins, target);
        System.out.println(res);
    }

}
