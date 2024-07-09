package day.y24m05;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author CuiChengLong
 * @Date 2024/5/18 15:44
 * @Description
 */
public class t_完成所有任务需要的最少轮数 {

    public static int minimumRounds(int[] tasks) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int t : tasks) {
            cnt.merge(t, 1, Integer::sum);
        }
        int ans = 0;
        for (int c : cnt.values()) {
            if (c == 1) {
                return -1;
            }
            ans += (c + 2) / 3;
        }
        return ans;
    }

    public static void main(String[] args) {
        minimumRounds(new int[]{2,2,3,3,2,4,4,4,4,4});
    }

}
