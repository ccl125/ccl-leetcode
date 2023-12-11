package exam.leetcode375周赛;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author CuiChengLong
 * @Date 2023/12/10 10:40
 * @Description
 */

public class t_2 {

    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < variables.length; i++) {
            int[] variable = variables[i];
            int a = variable[0];
            int b = variable[1];
            int c = variable[2];
            int m = variable[3];
            double pow = 1;
            for (int j = 0; j < b; j++) {
                pow = (pow * a) % 10;
            }
            pow %= 10;
            double pow2 = 1;
            for (int j = 0; j < c; j++) {
                pow2 = (pow2 * pow) % m;
            }
            pow2 %= m;
            if (pow2 == target) {
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        t_2 t = new t_2();
        int[][] variables = {{2, 3, 3, 10}, {3, 3, 3, 1}, {6, 1, 1, 4}};
        int target = 2;
        List<Integer> res = t.getGoodIndices(variables, target);
        System.out.println(res);
    }

}
