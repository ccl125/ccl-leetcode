package day.y23m11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

/**
 * @Author CuiChengLong
 * @Date 2023/11/29 13:45
 * @Description https://leetcode.cn/problems/smallest-number-in-infinite-set/?envType=daily-question&envId=2023-11-29
 */

public class D_11_29_无限集中的最小数字 {

    List<Integer> list = new ArrayList<>();

    public int popSmallest() {
        Collections.sort(list);
        return list.remove(0);
    }

    public void addBack(int num) {
        if (!list.contains(num)) {
            list.add(num);
        }
    }


}
