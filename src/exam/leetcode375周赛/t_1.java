package exam.leetcode375周赛;

/**
 * @Author CuiChengLong
 * @Date 2023/12/10 10:33
 * @Description
 */

public class t_1 {


    public int countTestedDevices(int[] batteryPercentages) {
        int res = 0;
        for (int i = 0; i < batteryPercentages.length; i++) {
            if (batteryPercentages[i] > 0) {
                res++;
                for (int j = i+1; j < batteryPercentages.length; j++) {
                    batteryPercentages[j] = Math.max(0, batteryPercentages[j] - 1);
                }
            }
        }
        return res;
    }

}
