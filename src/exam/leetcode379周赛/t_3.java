package exam.leetcode379周赛;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @Author CuiChengLong
 * @Date 2024/1/7 11:37
 * @Description
 */

public class t_3 {

    public int maximumSetSize(int[] nums1, int[] nums2) {
        int n = nums2.length;
        n /= 2;
        Map<Integer, Integer> num2Map = new HashMap<>();
        Map<Integer, Integer> num1Map = new HashMap<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int i = 0; i < nums2.length; i++) {
            if (num2Map.containsKey(nums2[i])) {
                num2Map.put(nums2[i], num2Map.get(nums2[i]) + 1);
            } else {
                num2Map.put(nums2[i], 1);
            }
        }

        for (int i = 0; i < nums1.length; i++) {
            if (num1Map.containsKey(nums1[i])) {
                num1Map.put(nums1[i], num1Map.get(nums1[i]) + 1);
            } else {
                num1Map.put(nums1[i], 1);
            }
        }

        HashSet<Integer> n1 = new HashSet<>();
        HashSet<Integer> n2 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            Integer sum = num2Map.get(nums1[i]);
            if (sum!= null && sum > 0 && n > 0) {
                num2Map.put(nums1[i], sum -1);
                n--;
            } else {
                n1.add(nums1[i]);
            }
            if (n1.size() == nums2.length/2) break;
        }
        n = nums2.length/2;
        for (int i = 0; i < nums2.length; i++) {
            Integer sum = num1Map.get(nums2[i]);
            if (sum!= null && sum > 0 && n > 0) {
                num1Map.put(nums2[i], sum -1);
                n--;
            } else {
                n2.add(nums2[i]);
            }
            if (n2.size() == nums2.length/2) break;
        }
        n1.addAll(n2);
        return n1.size();
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1,2,1,1};
        int[] num2 = new int[]{1,2,3,4};
        t_3 test = new t_3();
        System.out.println(test.maximumSetSize(num1, num2));
    }

}
