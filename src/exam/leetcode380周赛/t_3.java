package exam.leetcode380周赛;

/**
 * @Author CuiChengLong
 * @Date 2024/1/14 10:27
 * @Description
 */

public class t_3 {

    public static long findMaximumNumber(long k, int x) {
        long left = 1, right = Long.MAX_VALUE;

        while (left < right) {
            long mid = left + (right - left) / 2;
            long value = calculateValue(mid, x);

            if (value < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left - 1;
    }

    private static long calculateValue(long num, int x) {
        long count = 0;
        long index = 1;

        while (num > 0) {
            if (num % 2 == 1 && index % x == 0) {
                count++;
            }
            num /= 2;
            index++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(calculateValue(9, 1));
    }

}
