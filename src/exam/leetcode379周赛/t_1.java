package exam.leetcode379周赛;

/**
 * @Author CuiChengLong
 * @Date 2024/1/7 10:36
 * @Description
 */

public class t_1 {

    public int areaOfMaxDiagonal(int[][] dimensions) {
        double[] res = new double[dimensions.length];
        for (int i = 0; i < dimensions.length; i++) {
            int len = dimensions[i][0];
            int wide = dimensions[i][1];
            double sqrt = Math.sqrt(len * len + wide * wide);
            res[i] = sqrt;
        }
        double max = res[0];
        int temp = 0;
        for (int i = 1; i < res.length; i++) {
            if (res[i] >= max) {
                max = res[i];

            }
        }
        for (int i = 0; i < res.length; i++) {
            if (res[i] == max) {
                temp = Math.max(temp,dimensions[i][0]*dimensions[i][1]);
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        t_1 test = new t_1();
        int[][] dimensions = new int[][]{{6,5},{8,6},{2,10},{8,1},{9,2},{3,5},{3,5}};
        System.out.println(test.areaOfMaxDiagonal(dimensions));
    }

}
