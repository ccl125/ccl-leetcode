package day.y24m05;

/**
 * @Author CuiChengLong
 * @Date 2024/5/18 15:23
 * @Description
 */
public class D_05_18_找出可整除性得分最大的整数 {


    public static int maxDivScore(int[] nums, int[] divisors) {
        int score = 0;
        int res =Integer.MAX_VALUE;
        for (int i = 0; i < divisors.length; i++) {
            int flag = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] % divisors[i] == 0) {
                    flag++;
                }
            }
            System.out.println(i + " 的分数为 " + flag + "score = " + score);
            if (flag > score) {
                score = flag;
                res = divisors[i];
            }
            if (flag == score) {
                res = Math.min(res, divisors[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        maxDivScore(new int[]{4, 7, 9, 3, 9},new int[]{5,2, 3});
    }

}
