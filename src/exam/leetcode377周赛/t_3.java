package exam.leetcode377周赛;

import java.util.HashMap;

/**
 * @Author CuiChengLong
 * @Date 2023/12/24 11:42
 * @Description
 */

public class t_3 {

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        HashMap<Character, Transcation> map = new HashMap<>();
        for (int i = 0; i < original.length; i++) {
            Transcation transcation = map.get(original[i]);
            if (transcation == null) {
                Transcation t =new Transcation(original[i], changed[i], cost[i]);
                map.put(original[i], t);
            } else {
                if (transcation.cost < cost[i]) {
                    transcation.cost = cost[i];
                    transcation.target = changed[i];
                }
            }
        }
        int res = 0;
        char[] sc = source.toCharArray();
        char[] tc = target.toCharArray();
        for (int i = 0; i < sc.length; i++) {
            Transcation transcation = map.get(sc[i]);
            if (transcation == null) {
                return -1;
            } else {
                if (transcation.target == tc[i]) {
                    res += transcation.cost;
                } else {
                    res += cost[i];
                }
            }
        }
        return res;
    }

    class Transcation {
        char source;
        char target;
        int cost;

        public Transcation(char source, char target, int cost) {
            this.source = source;
            this.target = target;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        t_3 test = new t_3();
        String source = "abcd";
        String target = "acbe";
        char[] original = new char[]{'a', 'b', 'c', 'c', 'e', 'd'};
        char[] changed = new char[]{'b','c','b','e','b','e'};
        int[] cost = new int[]{2,5,5,1,2,20};
        System.out.println(test.minimumCost(source, target, original, changed, cost));
    }

}
