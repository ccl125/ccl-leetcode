package exam.leetcode377周赛;

import java.util.*;

/**
 * @Author CuiChengLong
 * @Date 2023/12/24 10:53
 * @Description
 */

public class t_2 {

//    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
//        int index = Math.min(m, n);
//        Arrays.sort(hFences);
//        Arrays.sort(vFences);
//        Stack<Integer> s1 = new Stack<>();
//        for (int i = 0; i < hFences.length; i++) {
//            s1.push(hFences[i]);
//        }
//        Stack<Integer> s2 = new Stack<>();
//        for (int i = 0; i < vFences.length; i++) {
//            s2.push(vFences[i]);
//        }
//        while (m-- > 0) {
//            if (m > n) {
//                continue;
//            }
//
//        }
//    }

    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        int mod = 1000000007;
        List<Integer> h = new ArrayList<>();
        List<Integer> v = new ArrayList<>();
        for (int i = 0; i < hFences.length; i++) {
            h.add(hFences[i]);
        }
        for (int i = 0; i < vFences.length; i++) {
            v.add(vFences[i]);
        }
        h.add(m);
        v.add(n);
        Collections.sort(h);
        Collections.sort(v);
        int hLength = h.size() - 1;
        int vLength = v.size() - 1;
        int res = help(m, n, hFences, vFences);
        while (hLength >= 0 && vLength >= 0) {
            if (h.get(hLength) > v.get(vLength)) {
                hLength--;
            } else if (h.get(hLength) < v.get(vLength)) {
                vLength--;
            } else {
                return ((h.get(hLength) - 1) % mod * (v.get(vLength) - 1) % mod) % mod;
            }
        }
        return res;
    }



    public int help(int m, int n, int[] hFences, int[] vFences) {
        int mod = 1000000007;
        List<Integer> h = new ArrayList<>();
        List<Integer> v = new ArrayList<>();
        for (int i = 0; i < hFences.length; i++) {
            h.add(hFences[i]);
        }
        for (int i = 0; i < vFences.length; i++) {
            v.add(vFences[i]);
        }
        h.add(m);
        v.add(n);
        HashSet<Integer> hs = new HashSet<>();
        HashSet<Integer> vs = new HashSet<>();
        for (int i = 0; i < h.size(); i++) {
            for (int j = 0; j < h.size(); j++) {
                if (h.get(j) - h.get(i) > 0) {
                    hs.add(h.get(j) - h.get(i));
                }
            }
        }
        for (int i = 0; i < v.size(); i++) {
            for (int j = 0; j < v.size(); j++) {
                if (v.get(j) - v.get(i) > 0){
                    vs.add(v.get(j) - v.get(i));
                }
            }
        }
        List<Integer> hList = new ArrayList<>(hs);
        List<Integer> vList = new ArrayList<>(vs);
        hList.add(m-1);
        vList.add(n-1);
        Collections.sort(hList);
        Collections.sort(vList);
        int hLength = hList.size() - 1;
        int vLength = vList.size() - 1;
        int res = -1;
        while (hLength >= 0 && vLength >= 0) {
            if (hList.get(hLength) > vList.get(vLength)) {
                hLength--;
            } else if (hList.get(hLength) < vList.get(vLength)) {
                vLength--;
            } else {
                return ((hList.get(hLength)) % mod * (vList.get(vLength)) % mod) % mod;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        t_2 test = new t_2();
        int m = 3;
        int n = 9;
        int[] hFences = new int[]{2};
        int[] vFences = new int[]{8,6,5,4};
        System.out.println(test.maximizeSquareArea(m, n, hFences, vFences));
    }

}
