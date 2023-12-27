package day.m12;

import java.util.Arrays;
import java.util.Collections;

/**
 * @Author: CuiChengLong
 * @Date: 2023/12/27 9:01
 * @Description
 */
public class D_12_27_保龄球游戏的获胜者 {

    public int isWinner(int[] player1, int[] player2) {
        long sum1 = 0;
        long sum2 = 0;
        helpMe(player1);
        helpMe(player2);
        for (int i = 0; i < player1.length; i++) {
            sum1 += player1[i];
            sum2 += player2[i];
        }
        if (sum1 == sum2) return 0;
        return sum1 > sum2 ? 1 : 2;
    }

    public void helpMe(int[] player) {
        int index = 0;
        int length = player.length;
        while (index < length) {
            if (player[index] == 10) {
                int add1 = index + 1;
                int add2 = index + 2;
                if (add1 < length) {
                    player[add1] *= 2;
                }
                if (add2 < length) {
                    player[add2] *= 2;
                }
                index = add2 + 1;
            } else {
                index++;
            }
        }
    }

    public static void main(String[] args) {
        D_12_27_保龄球游戏的获胜者 test = new D_12_27_保龄球游戏的获胜者();
        int[] player1 = new int[]{9,10,0};
        int[] player2 = new int[]{10,0,6};
        System.out.println(test.isWinner(player1, player2));
    }

}
