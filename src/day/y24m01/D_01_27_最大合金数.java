package day.y24m01;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author CuiChengLong
 * @Date 2024/1/27 18:39
 * @Description
 */

public class D_01_27_最大合金数 {

    int n;
    int budget;
    List<List<Integer>> composition;
    List<Integer> stock;
    List<Integer> cost;

    boolean isValid(long target) {
        for (List<Integer> currMachine : composition) {
            long remain = budget;
            for (int j = 0; j < n && remain >= 0; j++) {
                long need = Math.max(0, currMachine.get(j) * target - stock.get(j));
                remain -= need * cost.get(j);
            }
            if (remain >= 0) {
                return true;
            }
        }
        return false;
    }

    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition,
                                 List<Integer> stock, List<Integer> cost) {
        this.n = n;
        this.budget = budget;
        this.composition = composition;
        this.stock = stock;
        this.cost = cost;
        int l = -1;
        int r = budget / cost.get(0) + stock.get(0);
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (isValid(mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
//
//    作者：ylb
//    链接：https://leetcode.cn/problems/maximum-number-of-alloys/solutions/2621375/python3javacgotypescript-yi-ti-yi-jie-er-zghl/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
//

    public static void main(String[] args) {
        List<Integer> temp1 = new ArrayList<>();
        List<Integer> temp2 = new ArrayList<>();
        temp1.add(1);
        temp1.add(1);
        temp1.add(1);
        temp2.add(1);
        temp2.add(1);
        temp2.add(10);
        List<List<Integer>> composition = new ArrayList<>();
        composition.add(temp1);
        composition.add(temp2);
        List<Integer> stock = new ArrayList<>();
        stock.add(0);
        stock.add(0);
        stock.add(0);
        List<Integer> cost = new ArrayList<>();
        cost.add(1);
        cost.add(2);
        cost.add(3);
        D_01_27_最大合金数 test = new D_01_27_最大合金数();
        System.out.println(test.maxNumberOfAlloys(3, 3, 15, composition, stock, cost));

    }

}
