package hot100.h2_双指针;

/**
 * @Author CuiChengLong
 * @Date 2023/11/28 21:55
 * @Description
 */

public class H_5_盛最多水的容器 {

    //超时
    public int maxArea2(int[] height) {
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int len = j - i;
                int area = len * Math.min(height[i], height[j]);
                res = Math.max(area, res);
            }
        }
        return res;
    }

    //注意++和--操作要最后面执行，防止影响答案，也就是先用原先的r,l运算完再++--
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int res = 0;
        while (l < r) {
            if (height[l] <= height[r]) {
                res = Math.max(res, Math.min(height[l], height[r]) * (r - l++));
            } else {
                res = Math.max(res, Math.min(height[l], height[r]) * (r-- - l));
            }
        }
        return res;
    }

    //上面的代码可以优化为
    public int maxArea_new(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int res = 0;
        while (l < r) {
            if (height[l] <= height[r]) {
                res = Math.max(res, (r - l) * height[l++]);
            } else {
                res = Math.max(res, (r - l) * height[r--]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        H_5_盛最多水的容器 test = new H_5_盛最多水的容器();
//        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        int[] height = new int[]{1, 1};
        int area = test.maxArea(height);
        System.out.println(area);
    }

}
