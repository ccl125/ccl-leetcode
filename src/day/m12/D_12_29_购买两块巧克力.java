package day.m12;

import java.util.Arrays;

/**
 * @Author: CuiChengLong
 * @Date: 2023/12/29 9:01
 * @Description
 */
public class D_12_29_购买两块巧克力 {

    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int ans = prices[0] +prices[1];
        if (ans > money) {
            return money;
        }
        return money - ans;
    }

}
