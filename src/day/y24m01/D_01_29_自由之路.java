package day.y24m01;

import java.util.*;

/**
 * @Author: CuiChengLong
 * @Date: 2024/1/29 10:06
 * @Description dfs + 动态规划
 */
public class D_01_29_自由之路 {

    public int findRotateSteps(String ring, String key) {
        int len = ring.length();
        Map<Character, List<Integer>> map = new HashMap<>();
        char[] arr = ring.toCharArray();
        for (int i = 0; i < len; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], new ArrayList<>());
            }
            map.get(arr[i]).add(i);
        }
        HashMap<String, Integer> cache = new HashMap<>();
        return key.length() + dfs(0, 0, key.toCharArray(), map, len, cache);
    }

    private int dfs(int ringIdx, int keyIdx, char[] keyArr, Map<Character, List<Integer>> map, int ringLen, HashMap<String, Integer> cache) {
        if (keyIdx == keyArr.length) {
            return 0;
        }
        String cacheKey = ringIdx + "," + keyIdx;
        if (cache.containsKey(cacheKey)) {
            return cache.get(cacheKey);
        }
        char targetChar = keyArr[keyIdx];
        int res = Integer.MAX_VALUE;
        for (int targetIdx : map.get(targetChar)) {
            int min1 = Math.abs(ringIdx - targetIdx);
            int min2 = ringLen - min1;
            int nextPathLen = Math.min(min1, min2) + dfs(targetIdx, keyIdx + 1, keyArr, map, ringLen, cache);
            res = Math.min(res, nextPathLen);
        }
        cache.put(cacheKey, res);
        return res;
    }

    public static void main(String[] args) {
        D_01_29_自由之路 test = new D_01_29_自由之路();
        System.out.println(test.findRotateSteps2("godding", "gd"));
    }

    //动态规划 "godding" "gd"
    // x, x, x, x, x, x, x
    // x, x, x, x, x, x, x
    //每个g对应每个可以到的位置
    //g：1, max, max, max, max, max, 2
    //g：max, max, 4, 5, max, max, max
    //res：min(4,5);
    public int findRotateSteps2(String ring, String key) {
        List<Integer>[] post = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            post[i] = new ArrayList();
        }
        for (int i = 0; i < ring.length(); i++) {
            post[ring.charAt(i) - 'a'].add(i);
        }
        int[][] dp = new int[key.length()][ring.length()];
        for (int[] arr : dp) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        for (int i = 0; i < key.length(); i++) {
            for (int j : post[key.charAt(i) - 'a']) {
                if (i == 0) {
                    dp[i][j] = Math.min(dp[i][j], clac(ring.length(), 0, j) + 1);
                    continue;
                }
                for (int k : post[key.charAt(i - 1) - 'a']) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + clac(ring.length(), k, j) + 1);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int temp : dp[key.length() - 1]) {
            res = Math.min(res, temp);
        }
        return res;
//        return Arrays.stream(dp[key.length() - 1]).min().getAsInt();
    }

    private int clac(int n, int a, int b) {
        return Math.min((n + a - b) % n, (n + b - a) % n);
    }

}
