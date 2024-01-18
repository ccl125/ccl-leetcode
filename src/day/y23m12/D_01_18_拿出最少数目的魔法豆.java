package day.y23m12;

import java.util.*;

/**
 * @Author: CuiChengLong
 * @Date: 2024/1/18 9:49
 * @Description
 */
public class D_01_18_拿出最少数目的魔法豆 {

    // 只能减不能加
    // 求减掉的最小，就是求留下的最多
    public static long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        long sum = 0;
        int n = beans.length;
        long res = 0;
        for (int i = 0; i < beans.length; i++) {
            sum += beans[i];
            res = Math.max(res, (long) beans[i] * (n - i));
        }
        return sum - res;
    }

    public static long minimumRemoval2(int[] beans) {
        LinkedList<Integer> queue = new LinkedList<>();
        Arrays.sort(beans);
        long res = 0;
        for (int i = 0; i < beans.length; i++) {
            queue.addFirst(beans[i]);
        }
        while (!queue.isEmpty() && queue.size() >= 2) {
            int max = queue.getFirst();
            int tail = queue.getLast();
            int interval = max - tail;
            res += Math.min(interval, tail);
            queue.pollLast();
        }
        return res;
    }


    public static long minimumRemoval3(int[] beans) {
        Arrays.sort(beans);
        int[][] dp = new int[beans.length][2];
        // 第一个全拿光
        dp[0][0] = beans[0];
        // 第一个不拿，变成和第二个一样的
        dp[0][1] = beans[1] - beans[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = beans[i];
            dp[i][1] = Math.min(beans[i] - beans[i - 1], beans[i]);
        }
        return 0;
    }


    public static void main(String[] args) {
        int[] beans = new int[]{4,1,6,5};
        int[] beans2 = new int[]{12, 43, 63, 94};
        System.out.println(minimumRemoval(beans));
        System.out.println(minimumRemoval(beans2));
    }

}
