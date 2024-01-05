package day.y23m12;

/**
 * @Author CuiChengLong
 * @Date 2023/12/3 19:22
 * @Description
 */

public class D_12_03_可获得的最大点数 {

    public int maxScore(int[] cardPoints, int k) {
        int res = 0;
        int len = cardPoints.length;
        int[] temp = new int[len + 1];
        for (int i = 0; i < len; i++) {
            temp[i + 1] = temp[i] + cardPoints[i];
        }
        for (int i = 0; i <= k; i++) {
            res = Math.max(res, temp[i] + temp[len] - temp[len - k + i]);
        }
        return res;
    }

    public static void main(String[] args) {
        D_12_03_可获得的最大点数 d = new D_12_03_可获得的最大点数();
        int[] cardPoints = {1, 2, 3, 4, 5, 6, 1};
        int k = 3;
        int res = d.maxScore(cardPoints, k);
        System.out.println(res);
    }


}
