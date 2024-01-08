package day.y24m01;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Author: CuiChengLong
 * @Date: 2024/1/8 9:01
 * @Description
 */
public class D_01_08_回旋镖的数量 {

    public int numberOfBoomerangs(int[][] points) {
        HashSet<int[]> set = new HashSet<>(Arrays.asList(points));
        int res = 0;
        for (int[] mid : set) {
            int x = mid[0];
            int y = mid[1];
            for (int i = 0; i < points.length; i++) {
                if (points[i][0] == x && points[i][1] == y) continue;
                int a = Math.abs(points[i][0] - x);
                int b = Math.abs(points[i][1] - y);
                for (int j = i + 1; j < points.length; j++) {
                    if (points[j][0] == x && points[j][1] == y) continue;
                    int c = Math.abs(points[j][0] - x);
                    int d = Math.abs(points[j][1] - y);
                    if (a * a + b * b == c * c + d * d) res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        D_01_08_回旋镖的数量 test = new D_01_08_回旋镖的数量();
        int[][] points = new int[][]{{0,0},{1,0},{2,0}};
        System.out.println(test.numberOfBoomerangs(points));
    }

}
