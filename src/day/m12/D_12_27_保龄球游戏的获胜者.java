package day.m12;

/**
 * @Author: CuiChengLong
 * @Date: 2023/12/27 9:01
 * @Description
 */
public class D_12_27_保龄球游戏的获胜者 {

    public int isWinner(int[] player1, int[] player2) {
        long sum1 = 0;
        long sum2 = 0;
        int score1 = getScore(player1);
        int score2 = getScore(player2);
        for (int i = 0; i < player1.length; i++) {
            sum1 += player1[i];
            sum2 += player2[i];
        }
        if (sum1 == sum2) return 0;
        return sum1 > sum2 ? 1 : 2;
    }
    public int getScore(int[] player) {
        int score = 0;
        for (int i = 0; i < player.length; ++i) {
            if ((i > 0 && player[i - 1] == 10) || (i > 1 && player[i - 2] == 10)) {
                score += player[i] * 2;
            } else {
                score += player[i];
            }
        }
        return score;
    }


    public static void main(String[] args) {
        D_12_27_保龄球游戏的获胜者 test = new D_12_27_保龄球游戏的获胜者();
        int[] player1 = new int[]{7,10,2,6,8,5,4,6,10,9,1,4,3,10,0,9,6,1,0};
        int[] player2 = new int[]{2,1,9,4,5,0,6,5,6,10,10,4,8,8,6,9,2,9,5};
        System.out.println(test.isWinner(player1, player2));
    }

}
