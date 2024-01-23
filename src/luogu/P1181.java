package luogu;

import java.util.Scanner;

/**
 * @Author: CuiChengLong
 * @Date: 2024/1/23 17:54
 * @Description https://www.luogu.com.cn/problem/P1181
 */
public class P1181 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int res = 0;
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans += arr[i];
            if (ans >= m) {
                res++;
                ans = 0;
            }
        }
        System.out.println(res);
    }

}
