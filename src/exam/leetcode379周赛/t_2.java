package exam.leetcode379周赛;

/**
 * @Author CuiChengLong
 * @Date 2024/1/7 11:02
 * @Description
 */

public class t_2 {

    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        int temp1 = helpX(a, b, c, d, e, f);
        int temp2 = helpB(a, b, c, d, e, f);
        return Math.min(temp1, temp2);
    }

    private int helpB(int a, int b, int c, int d, int e, int f) {
        if (b == f) {
            if (d == f) {
                int min = Math.min(a, e);
                int max = Math.max(a, e);
                //同列，但堵着了
                if (c > min && c < max) return 2;
            }
            return 1;
        }
        if (a == e) {
            if (c == e) {
                int min = Math.min(b, f);
                int max = Math.max(b, f);
                //同行，被象堵着了
                if (d > min && d< max) return 2;
            }
            return 1;
        }
        return 2;
    }

    private int helpX(int a, int b, int c, int d, int e, int f) {
        int res = Integer.MAX_VALUE;
        if (Math.abs(e - c) == Math.abs(f - d)) {
            res = 1;
            //兵挡象，先移走兵
            if (Math.abs(e - a) == Math.abs(f - b)) {
                int maxIndex = Math.max(e, c);
                int minIndex = Math.min(e, c);
                // 兵真的挡住象了
                if (a < maxIndex && a > minIndex) {
                    res += 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        t_2 test = new t_2();
        System.out.println(test.minMovesToCaptureTheQueen(4, 3, 3, 4, 5, 2));
    }

}
