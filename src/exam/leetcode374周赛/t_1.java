package exam.leetcode374周赛;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author CuiChengLong
 * @Date 2023/12/3 10:31
 * @Description
 */

public class t_1 {


    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < mountain.length - 1; i++) {
            if (mountain[i] > mountain[i - 1] && mountain[i] > mountain[i + 1]) {
                res. add(i);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        t_1 t = new t_1();
        int[] mountain = {1,4,3,8,5};
        List<Integer> res = t.findPeaks(mountain);
        System.out.println(res);
    }

}
