package day.y23m12;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: CuiChengLong
 * @Date: 2023/12/25 19:24
 * @Description
 */
public class D_12_25_不浪费原料的汉堡制作方案 {

    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> res = new ArrayList<>();
        int x = tomatoSlices / 2 - cheeseSlices;
        int y = 2 * cheeseSlices - tomatoSlices / 2;
        if (4 * x + 2 * y != tomatoSlices || x < 0 || y < 0 || x + y != cheeseSlices) return res;
        res.add(x);
        res.add(y);
        return res;
    }

    public static void main(String[] args) {
        D_12_25_不浪费原料的汉堡制作方案 test = new D_12_25_不浪费原料的汉堡制作方案();
        List<Integer> res = test.numOfBurgers(16, 7);
        System.out.println(res);
    }

}
