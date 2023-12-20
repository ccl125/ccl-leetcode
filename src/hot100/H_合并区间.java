package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: CuiChengLong
 * @Date: 2023/12/19 20:09
 * @Description
 */
public class H_合并区间 {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int l = intervals[i][0];
            int r = intervals[i][1];
            for (int j = i + 1; j < intervals.length; j++) {
                int nextL = intervals[j][0];
                if (nextL <= r) {
                    r = Math.max(r, intervals[j][1]);
                    i = j;
                } else {
                    break;
                }
            }
            res.add(new int[]{l, r});
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        H_合并区间 test = new H_合并区间();
        int[][] intervals = new int[][]{{1, 4}, {2, 3}};
        int[][] merge = test.merge(intervals);
        for (int i = 0; i < merge.length; i++) {
            System.out.println(Arrays.toString(merge[i]));
        }
    }

}
