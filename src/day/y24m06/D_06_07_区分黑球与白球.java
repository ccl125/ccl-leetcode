package day.y24m06;

/**
 * @Author CuiChengLong
 * @Date 2024/6/7 19:02
 * @Description
 */

public class D_06_07_区分黑球与白球 {

    public static long minimumSteps(String s) {
        int res = 0;
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            for (int j = i; j < c.length - i - 1; j++) {
                if (c[j + 1] == '0' && c[j] == '1') {
                    swap(c, j + 1, j);
                    res++;
                }
            }
        }
        return res;
    }

    public static void swap(char[] c, int a, int b) {
        char temp = c[a];
        c[a] = c[b];
        c[b] = temp;
    }

    public static void main(String[] args) {
        minimumSteps("11000111");
    }

}
