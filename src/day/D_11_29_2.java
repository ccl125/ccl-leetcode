package day;

import java.util.TreeSet;

/**
 * @Author: CuiChengLong
 * @Date: 2023/11/29 14:21
 * @Description
 */
public class D_11_29_2 {

    TreeSet<Integer> set = new TreeSet<>();

    public void support() {
        for (int i = 1; i < 1001; i++) {
            set.add(i);
        }
    }

    public int popSmallest() {
        return set.pollFirst();
    }

    public void addBack(int num) {
        set.add(num);
    }

}
