package day.y24m01;

/**
 * @Author CuiChengLong
 * @Date 2024/1/22 21:38
 * @Description
 */

public class D_01_22_最大交换 {

    public static int maximumSwap(int num) {
        String ss = String.valueOf(num);
        char[] s = ss.toCharArray();
        int maxIdx = s.length - 1;
        int p = -1, q = 0;
        for (int i = s.length - 2; i >= 0; i--) {
            if (s[i] > s[maxIdx]) { // s[i] 是目前最大数字
                maxIdx = i;
            } else if (s[i] < s[maxIdx]) { // s[i] 右边有比它大的
                p = i;
                q = maxIdx; // 更新 p 和 q
            }
        }
        if (p == -1) { // 这意味着 s 是降序的
            return num;
        }
        char temp = s[p];
        s[p] = s[q];
        s[q] = temp; // 交换 s[p] 和 s[q]
        return Integer.parseInt(String.valueOf(s));
    }

    public static void main(String[] args) {
        System.out.println(maximumSwap(98368));
        System.out.println(maximumSwap(2736));
    }

}
