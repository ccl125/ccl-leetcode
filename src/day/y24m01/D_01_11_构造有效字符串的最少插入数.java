package day.y24m01;

/**
 * @Author: CuiChengLong
 * @Date: 2024/1/11 13:34
 * @Description
 */
public class D_01_11_构造有效字符串的最少插入数 {

    public static int addMinimum(String word) {
        String abc = "abc";
        //word指针
        int pointWord = 0;
        //abc指针
        int pointAbc = 0;
        int res = 0;
        while (pointWord < word.length()) {
            if (abc.charAt(pointAbc % 3) == word.charAt(pointWord)) {
                pointAbc++;
                pointWord++;
            } else {
                pointAbc++;
                res++;
            }
        }
        if (pointAbc % 3 != 0) res += (3 - pointAbc % 3);
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(addMinimum("b"));
//        System.out.println(addMinimum("aaa"));
        System.out.println(addMinimum("abc"));
    }

}
