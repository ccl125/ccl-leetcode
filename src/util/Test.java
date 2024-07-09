package util;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author CuiChengLong
 * @Date 2024/5/18 23:54
 * @Description
 */

public class Test {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Integer> dic = new HashMap<>();
        String s = "a";

        while (scanner.hasNextLine()) {
            int val = scanner.nextInt();
            dic.put(val, dic.getOrDefault(val, 0) + 1);
        }

        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : dic.entrySet()) {
            int m = entry.getKey();
            int n = entry.getValue();
            ans += Math.ceil((double) n / (m + 1)) * (m + 1);
        }

        System.out.println(ans);
    }
}
